package com.turistory.android.communication.dto.distance_matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cristóbal Romero Rossi <cristobalromerorossi@gmail.com>
 * @version 1.0
 */

public class DistanceMatrix {
    private List<String> destinationAddresses;
    private List<String> originAddresses;
    private List<Element> rows;
    private String status;

    public DistanceMatrix() {
        destinationAddresses = new ArrayList<>();
        originAddresses = new ArrayList<>();
        rows = new ArrayList<>();
    }

    public DistanceMatrix(List<String> destinationAddresses, List<String> originAddresses,
                          List<Element> rows, String status) {
        this.destinationAddresses = destinationAddresses;
        this.originAddresses = originAddresses;
        this.rows = rows;
        this.status = status;
    }

    public List<String> getDestinationAddresses() {
        return destinationAddresses;
    }

    public void setDestinationAddresses(List<String> destinationAddresses) {
        this.destinationAddresses = destinationAddresses;
    }

    public List<String> getOriginAddresses() {
        return originAddresses;
    }

    public void setOriginAddresses(List<String> originAddresses) {
        this.originAddresses = originAddresses;
    }

    public List<Element> getRows() {
        return rows;
    }

    public void setRows(List<Element> rows) {
        this.rows = rows;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
