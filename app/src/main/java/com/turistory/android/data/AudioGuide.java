package com.turistory.android.data;

import com.example.jean.jcplayer.JcAudio;

/**
 * Created by Ivan on 21/02/2017.
 */

public class AudioGuide {

    private int id;
    private String title;
    private String ruta;
    private  int cover;
    private int portada;
    private int audio;
    private  String guion;
    private String estado;

    public AudioGuide(int id, String title, String ruta, int cover, int portada, int audio, String guion, String estado) {
        this.id = id;
        this.title = title;
        this.ruta = ruta;
        this.cover = cover;
        this.portada = portada;
        this.audio = audio;
        this.guion = guion;
        this.estado = estado;
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

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getCover() {
        return cover;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }

    public int getPortada() {
        return portada;
    }

    public void setPortada(int portada) {
        this.portada = portada;
    }

    public int getAudio() {
        return audio;
    }

    public void setAudio(int audio) {
        this.audio = audio;
    }

    public String getGuion() {
        return guion;
    }

    public void setGuion(String guion) {
        this.guion = guion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
