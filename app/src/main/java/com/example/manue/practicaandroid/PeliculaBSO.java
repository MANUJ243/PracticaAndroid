package com.example.manue.practicaandroid;

/**
 * Created by manue on 10/02/2018.
 */

public class PeliculaBSO {
    private String Title;
    private String url;
    private int Thumbnail;

    public PeliculaBSO() {
    }

    public PeliculaBSO(String title, String url, int thumbnail) {
        Title = title;
        this.url = url;
        Thumbnail = thumbnail;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}
