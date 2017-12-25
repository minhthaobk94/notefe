package com.thaontm.project.notefecore.model;

public class News {
    private int id;

    private String title;

    private String date;

    public News(int id, String title, String date) {
        this.id = id;
        this.title = title;
        this.date = date;
    }

    public News(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
