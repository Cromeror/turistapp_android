package com.turistory.android.activity.view.custom.data;

/**
 * @author Cristóbal Romero Rossi <cristobalromerorossi@gmail.com>
 * @version 1.0
 */

public class MarkerPlaceData {
    private int id;
    private String title;
    private String distance;

    public MarkerPlaceData() {
    }

    public MarkerPlaceData(String title, int id) {
        this.title = title;
        this.id = id;
    }

    public MarkerPlaceData(int id, String title, String distance) {
        this.id = id;
        this.title = title;
        this.distance = distance;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MarkerPlaceData{" +
                "title :'" + title + '\'' +
                ", distance :'" + distance + '\'' +
                '}';
    }
}
