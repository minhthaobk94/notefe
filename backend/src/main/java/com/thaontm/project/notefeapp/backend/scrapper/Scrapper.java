package com.thaontm.project.notefeapp.backend.scrapper;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.thaontm.project.notefeapp.backend.core.model.Post;
import com.thaontm.project.notefeapp.backend.core.model.Segment;
import com.thaontm.project.notefeapp.backend.core.model.SegmentType;
import com.thaontm.project.notefeapp.backend.utils.GsonUtils;
import com.thaontm.project.notefeapp.backend.utils.StringUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Component
public class Scrapper {
    private static final Logger log = LoggerFactory.getLogger(Scrapper.class);
    private static final String NEWS_LIST_URL = "https://www3.nhk.or.jp/news/easy/news-list.json";

    private List<Post> posts;

    public Scrapper() {
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
        } catch (NullPointerException e) {
            log.error(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
            log.error(e.getMessage());
        }
    }

    public List<Post> getPosts() {
        if (CollectionUtils.isEmpty(posts)) {
            return new ArrayList<>();
        }
        return this.posts;
    }

    private List<Post> scrapePosts() {
        List<Post> posts = new ArrayList<>();
        try {
            final String json = IOUtils.toString(new URL(NEWS_LIST_URL));
            final JsonParser parser = new JsonParser();
            final JsonElement element = parser.parse(json);
            Set<Map.Entry<Date, List<DailyPost>>> postsSet = null;
            if (element.isJsonArray()) {
                final JsonArray array = element.getAsJsonArray();
                if (array.get(0).isJsonObject()) {
                    JsonElement childElement = array.get(0);
                    if (childElement.isJsonObject()) {
                        final JsonObject object = childElement.getAsJsonObject();
                        postsSet = convert(object.entrySet());
                    }
                }
            }
            if (postsSet != null) {
                // get posts for the last date
                Iterator<Map.Entry<Date, List<DailyPost>>> iterator = postsSet.iterator();
                posts.addAll(convert(iterator.next()));
                posts.addAll(convert(iterator.next()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return posts;
    }

    private List<Post> convert(final Map.Entry<Date, List<DailyPost>> entry) {
        final List<Post> result = new ArrayList<>();
        if (entry == null || entry.getKey() == null || entry.getValue() == null) {
            return result;
        }
        for (final DailyPost dailyPost : entry.getValue()) {
            final Post post = new Post(dailyPost.getNewsId(), dailyPost.getNewsWebUrl(), entry.getKey(), dailyPost.getNewsWebImageUri(), dailyPost.getNewsEasyVoiceUri());
            final Set<Segment> segments = new LinkedHashSet<>();
            final List<String> segmentSet = StringUtils.getInstance().breakPostToSegments(dailyPost.getTextContent());
            long segmentIndex = 0;
            for (final String s : segmentSet) {
                final Segment segment = new Segment();
                segment.setSegmentType(new SegmentType(segmentIndex == 0 ? "title" : "body"));
                segment.setIndex(segmentIndex++);
                segment.setText(s);
                segment.setViTranslation(getViTranslation(s));
                segments.add(segment);
            }
            post.setSegments(segments);
            // set default vocab list
            post.setVocabularies(new HashSet<>());
            result.add(post);
        }
        return result;
    }

    private Set<Entry<Date, List<DailyPost>>> convert(final Set<Map.Entry<String, JsonElement>> entrySet) {
        final Set<Map.Entry<Date, List<DailyPost>>> result = new LinkedHashSet<>();
        final Gson gson = GsonUtils.getGson();
        entrySet.forEach(entry -> {
            result.add(new Entry<Date, List<DailyPost>>() {
                @Override
                public Date getKey() {
                    try {
                        return new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(entry.getKey());
                    } catch (ParseException e) {
                        e.printStackTrace();
                        return new Date(1970, 1, 1);
                    }
                }

                @Override
                public List<DailyPost> getValue() {
                    final JsonArray array = entry.getValue().getAsJsonArray();
                    final List<DailyPost> posts = new ArrayList<>();
                    array.forEach(e -> posts.add(gson.fromJson(e, DailyPost.class)));
                    return posts;
                }

                @Override
                public List<DailyPost> setValue(final List<DailyPost> value) {
                    return value;
                }
            });
        });
        return result;
    }

    private String getViTranslation(final String segmentText) {
        final Translate translate = createTranslateService();
        final Translation translation = translate.translate(
            segmentText,
            TranslateOption.sourceLanguage("ja"),
            TranslateOption.targetLanguage("vi")
        );

        return translation.getTranslatedText().replace("&quot;", "\"");
    }

    /**
     * Create Google Translate API Service.
     *
     * @return Google Translate Service
     */
    private Translate createTranslateService() {
        return TranslateOptions.newBuilder()
            .setApiKey("api_key")
            .build()
            .getService();
    }
}
