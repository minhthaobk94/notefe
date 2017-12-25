package com.thaontm.project.notefeweb.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
            links.remove(0);
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
            titles.remove(0);
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
            result = result.concat(line + '\n' + '\n' + '\n');
        }
        return result;
    }

    public String getDateSt(String title) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        Date date = parseDate(title.substring(1, 11));
        return formatter.format(date);
    }

    public String getTitle(String title) {
        return title.substring(12);
    }

    public Date parseDate(String dateSt) {
        Date date = null;
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        try {
            date = formatter.parse(dateSt);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public Date parseDate1(String dateSt) {
        Date date = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        try {
            date = formatter.parse(dateSt);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    public static boolean isToday(Date date) {
        Date today = new Date();
        if (!date.equals(today)) {
            return false;
        } else
            return true;
    }
}
