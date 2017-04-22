package com.turistory.android.communication.dto.distance_matrix;

/**
 * @author Cristóbal Romero Rossi <cristobalromerorossi@gmail.com>
 * @version 1.0
 */

public class Element {
    private Item distance;
    private Item duration;
    private String status;

    public Element() {
    }

    public Element(Item distance, Item duration, String status) {
        this.distance = distance;
        this.duration = duration;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Item getDistance() {
        return distance;
    }

    public void setDistance(Item distance) {
        this.distance = distance;
    }

    public Item getDuration() {
        return duration;
    }

    public void setDuration(Item duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Element{" +
                "distance=" + distance +
                ", duration=" + duration +
                ", status='" + status + '\'' +
                '}';
    }
}