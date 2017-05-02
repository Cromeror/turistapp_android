package com.turistory.android.data;

import java.util.List;

/**
 * Created by Ivan on 21/02/2017.
 */

public class AudioGuide {

    private int id;
    private String title;
    private String ruta;
    private int cover;
    private int portada;
    private List<Integer> gallery;
    private int audio;
    private String guion;
    private int estado;
    private Double latitude;
    private Double longitude;

    public AudioGuide(int id, String title, String ruta, int cover, int portada, int audio,
                      String guion, int estado, Double latitude, Double longitude,
                      List<Integer> gallery) {
        this.id = id;
        this.title = title;
        this.ruta = ruta;
        this.cover = cover;
        this.gallery = gallery;
        this.portada = portada;
        this.audio = audio;
        this.guion = guion;
        this.estado = estado;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String obtenerEstado() {

        if (this.estado == 0) {
            return "GRATIS";
        }
        return "BLOQUEADO";

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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public List<Integer> getGallery() {
        return gallery;
    }

    public void setGallery(List<Integer> gallery) {
        this.gallery = gallery;
    }
}
