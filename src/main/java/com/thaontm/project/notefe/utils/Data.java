package com.thaontm.project.notefe.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Data {
    public static final String WEBSITE_URL = "https://www.reddit.com/r/NHKEasyNews/";
    public static final String DOMAIN = "https://www.reddit.com";

    public List<String> getLinks() {
        List<String> links = new ArrayList<>();
        try {
            Document document = Jsoup.connect(WEBSITE_URL).get();
            Element siteTable = document.getElementById("siteTable");
            Elements elements = siteTable.getElementsByClass("top-matter");
            for (Element element : elements) {
                Elements link = element.getElementsByClass("title");
                String linkHref = link.attr("href");
                String linkTitle = DOMAIN + linkHref;
                links.add(linkTitle);
            }
//            links.remove(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return links;
    }

    public List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        try {
            Document document = Jsoup.connect(WEBSITE_URL).get();
            Element siteTable = document.getElementById("siteTable");
            Elements elements = siteTable.getElementsByClass("top-matter");
            for (Element element : elements) {
                String title = element.select("a").first().text();
                titles.add(title);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return titles;
    }
}
