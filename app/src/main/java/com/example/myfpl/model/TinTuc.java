package com.example.myfpl.model;

public class TinTuc {
    private String title,content,date,hinh;
    private int idNews;

    public TinTuc(int idNews, String title, String content, String date, String hinh) {
        this.idNews = idNews;
        this.title = title;
        this.content = content;
        this.date = date;
        this.hinh = hinh;
    }

    public int getIdNews() {
        return idNews;
    }

    public void setIdNews(int idNews) {
        this.idNews = idNews;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }
}

