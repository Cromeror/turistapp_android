package com.turistory.android.communication.dto.distance_matrix;

/**
 * @author Cristóbal Romero Rossi <cristobalromerorossi@gmail.com>
 * @version 1.0
 */

public class Item {
    private String text;
    private Integer value;

    public Item(String text) {
        this.text = text;
    }

    public Item(String text, Integer value) {
        this.text = text;
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
