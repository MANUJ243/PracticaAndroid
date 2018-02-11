package com.example.manue.practicaandroid;

public class PeliculaBSO {
    private String Title;
    private String url;
    private String audio;

    public PeliculaBSO() {
    }

    public PeliculaBSO(String title, String url, String audio) {
        Title = title;
        this.url = url;
        this.audio = audio;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
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
