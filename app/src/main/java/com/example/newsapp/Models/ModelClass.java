package com.example.newsapp.Models;

import java.util.Date;

public class ModelClass {
    String _id;
    String author;
    String title;
    String description;
    String url;
    String urlToImage;
    String view;


    public void setPublishAt(Date publishAt) {
        this.publishAt = publishAt;
    }

    Date publishAt;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public ModelClass(String _id, String author, String title, String description, String url, String urlToImage, Date publishAt, String view) {
        this._id = _id;
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishAt = publishAt;
        this.view = view;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public Date getPublishAt() {
        return publishAt;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }


}
