package com.example.adminstration.homework;

/**
 * Created by adminstration on 2017/11/13.
 */

public class IData {
    private String NewsID,Title,Abstract,ImageUrl,PublishDate,Author;

    public String getNewsID() {
        return NewsID;
    }

    public void setNewsID(String newsID) {
        NewsID = newsID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAbstract() {
        return Abstract;
    }

    public void setAbstract(String anAbstract) {
        Abstract = anAbstract;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getPublishDate() {
        return PublishDate;
    }

    public void setPublishDate(String publishDate) {
        PublishDate = publishDate;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }
}
