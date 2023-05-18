package org.example.dto;

public class StationData {

    private int customerId;

    private int kwh;

    public StationData(int customerId, int kwh) {
        this.customerId = customerId;
        this.kwh = kwh;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getKwh() {
        return kwh;
    }

    public void setKwh(int kwh) {
        this.kwh = kwh;
    }
}
