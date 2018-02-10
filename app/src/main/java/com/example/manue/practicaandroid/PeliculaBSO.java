package com.example.manue.practicaandroid;

/**
 * Created by manue on 10/02/2018.
 */

public class PeliculaBSO {
    private String Title;
    private String url;

    public PeliculaBSO() {
    }

    public PeliculaBSO(String title, String url) {
        Title = title;
        this.url = url;
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
}
