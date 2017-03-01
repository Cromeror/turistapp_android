package com.turistory.android.data;

import com.example.jean.jcplayer.JcAudio;

/**
 * Created by Ivan on 21/02/2017.
 */

public class AudioGuide {

    private int id;
    private String title;
    private String subtitle;
    private  int cover;
    private int audio;

    public AudioGuide(int id, String title, String subtitle, int cover, int audio) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.cover = cover;
        this.audio = audio;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAudio() {
        return audio;
    }

    public void setAudio(int audio) {
        this.audio = audio;
    }

    public int getCover() {
        return cover;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
