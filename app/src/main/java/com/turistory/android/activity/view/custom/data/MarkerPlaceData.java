package com.turistory.android.activity.view.custom.data;

/**
 * @author Cristóbal Romero Rossi <cristobalromerorossi@gmail.com>
 * @version 1.0
 */

public class MarkerPlaceData {
    private String title;
    private String Distance;

    public MarkerPlaceData() {
    }

    public MarkerPlaceData(String title, String distance) {
        this.title = title;
        Distance = distance;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDistance() {
        return Distance;
    }

    public void setDistance(String distance) {
        Distance = distance;
    }

    @Override
    public String toString() {
        return "MarkerPlaceData{" +
                "title :'" + title + '\'' +
                ", Distance :'" + Distance + '\'' +
                '}';
    }
}
