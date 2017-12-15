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
    public static final char POINT = '。';

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

    public String getContent(int i) {
        String link = getLinks().get(i);
        String content = "No content";
        try {
            Document document = Jsoup.connect(link).get();
            Element element = document.getElementsByClass("expando").first();
            content = element.text();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public String formatContent(String content) {
        String[] splitArr1 = content.split("html");
        String[] splitArr2 = splitArr1[1].split("I");
        String[] cutContentArr = splitArr2[0].split(String.valueOf(Data.POINT));
        int lines = cutContentArr.length;
        String result = "";
        String line;
        for (int i = 0; i < lines - 1; i++) {
            line = cutContentArr[i].trim() + Data.POINT;
            result = result.concat(line + '\n' + '\n' +'\n');
        }
        return result;
    }

    public String getDateSt(String title) {
        return title.substring(1, 11);
    }

    public String getTitle(String title) {
        return title.substring(12);
    }
}
