package com.example.healthmonitoring;

public class Health {
    private int weight;
    private int stepsCount;

    public Health(int weight, int stepsCount) {
        this.weight = weight;
        this.stepsCount = stepsCount;
    }


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getStepsCount() {
        return stepsCount;
    }

    public void setStepsCount(int stepsCount) {
        this.stepsCount = stepsCount;
    }
}
