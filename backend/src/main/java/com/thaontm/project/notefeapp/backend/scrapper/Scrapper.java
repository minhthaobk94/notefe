package com.thaontm.project.notefeapp.backend.scrapper;

import com.thaontm.project.notefeapp.backend.core.model.Post;
import com.thaontm.project.notefeapp.backend.core.model.Segment;
import com.thaontm.project.notefeapp.backend.core.model.SegmentType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class Scrapper {
    private static final Logger log = LoggerFactory.getLogger(Scrapper.class);

    private List<Post> posts;

    public Scrapper() throws IOException, ParseException {
        this.posts = scrapePosts();
    }

    /**
     * The scrapper will scrape for posts at 17:00:00 everyday.
     */
    @Scheduled(cron = "0 0 17 * * ?")
    public void scrape() {
        try {
            log.info(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
            this.posts = scrapePosts();
        } catch (IOException | ParseException e) {
            log.error(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
            log.error(e.getMessage());
        }
    }

    public List<Post> getPosts() {
        return this.posts;
    }

    public List<Post> scrapePosts() throws IOException, ParseException {
        final List<Post> posts = new ArrayList<>();
        final Document doc = Jsoup.connect("https://www.reddit.com/r/NHKEasyNews/").get();
        final Elements segments = doc.select("div.entry > div.top-matter > p.title > a.title");

        final List<String> links = new ArrayList<>();
        for (Element e : segments) {
            final String link = e.absUrl("href");
            if (link != null && !link.contains("discord_server")) {
                links.add(link);
            }
        }

        for (String link : links.subList(0, 7)) {
            posts.add(getPostByLink(link));
        }

        return posts;
    }

    private Post getPostByLink(final String redditLink) throws IOException, ParseException {
        final Post post = new Post();
        final Set<Segment> segments = new HashSet<>();
        final Document doc = Jsoup.connect(redditLink).get();

        final Element postTitleElement = doc.selectFirst("div#siteTable")
            .selectFirst("p.title")
            .selectFirst("a.title.may-blank");
        final Segment title = new Segment();
        title.setText(postTitleElement.text());
        title.setIndex(post.getSegmentIndex());
        title.setSegmentType(new SegmentType("title"));
        segments.add(title);
        post.setSubmitted(extractDateFromTitle(postTitleElement.text()));
        log.info(extractDateFromTitle(postTitleElement.text()).toString());

        final Element contentBoxElement = doc.selectFirst("div#siteTable").selectFirst("div.md");
        final String postLink = contentBoxElement.selectFirst("a").text();
        post.setLink(postLink);
        post.setNhkEasyId(extractIdFromLink(postLink));
        log.info(postLink);

        final Elements segmentsElements = contentBoxElement.getElementsByTag("p");
        for (int i = 0; i < segmentsElements.size(); i++) {
            if (i == 0 || i == segmentsElements.size() - 1
                || segmentsElements.get(i).text().trim().length() == 0) {
            } else {
                final Segment segment = new Segment();
                segment.setText(segmentsElements.get(i).text());
                segment.setIndex(post.getSegmentIndex());
                segment.setSegmentType(new SegmentType("body"));

                segments.add(segment);
            }
        }

        post.setSegments(segments);
        return post;
    }

    /**
     * link must be like this: http://www3.nhk.or.jp/news/easy/k10011339591000/k10011339591000.html.
     */
    private String extractIdFromLink(final String postLink) {
        if (postLink == null) return "";
        else {
            return postLink.replace("http://www3.nhk.or.jp/news/easy/", "")
                .replace(".html", "")
                .split("/")[0];
        }
    }

    /**
     * @param title must be like this: [02/23/2018] 大林宣彦監督「広島に原爆が落とされるまでを映画にする」
     * @return date from title
     */
    private Date extractDateFromTitle(final String title) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("mm/DD/yyyy");
        return format.parse(title.trim().split(" ")[0].substring(1, 11));
    }
}
