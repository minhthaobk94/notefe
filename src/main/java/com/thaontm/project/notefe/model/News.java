package com.thaontm.project.notefe.model;

public class News {
    private String link;
    private String title;

    public News() {
    }

    public News(String link, String title) {
        this.link = link;
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
