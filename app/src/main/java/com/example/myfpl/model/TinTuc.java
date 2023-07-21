package com.example.myfpl.model;

public class TinTuc {
     public   String idNews,title,content,date;

     public TinTuc(String idNews, String title, String content, String date) {
          this.idNews = idNews;
          this.title = title;
          this.content = content;
          this.date = date;

     }
     public TinTuc( String title, String content, String date) {
          this.idNews = idNews;
          this.title = title;
          this.content = content;
          this.date = date;
     }

     public String getIdNews() {
          return idNews;
     }

     public void setIdNews(String idNews) {
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
}

