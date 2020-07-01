package com.example.healthmonitoring;

import java.util.Date;

public class Pressure {
    private int topPressure;
    private int lowerPressure;
    private int pulse;
    private boolean tachycardia;
    private String measurementDate;

    public Pressure(int topPressure, int lowerPressure, int pulse, boolean tachycardia, String measurementDate) {
        this.topPressure = topPressure;
        this.lowerPressure = lowerPressure;
        this.pulse = pulse;
        this.tachycardia = tachycardia;
        this.measurementDate = measurementDate;
    }

    public int getTopPressure() {
        return topPressure;
    }

    public void setTopPressure(int topPressure) {
        this.topPressure = topPressure;
    }

    public int getLowerPressure() {
        return lowerPressure;
    }

    public void setLowerPressure(int lowerPressure) {
        this.lowerPressure = lowerPressure;
    }

    public int getPulse() {
        return pulse;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }

    public boolean isTachycardia() {
        return tachycardia;
    }

    public void setTachycardia(boolean tachycardia) {
        this.tachycardia = tachycardia;
    }

    public String getMeasurementDate() {
        return measurementDate;
    }

    public void setMeasurementDate(String measurementDate) {
        this.measurementDate = measurementDate;
    }
}
