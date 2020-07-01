package com.example.healthmonitoring;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String name;
    private int age;
    private ArrayList<Pressure> pressures = new ArrayList<>();
    private ArrayList<Health> health = new ArrayList<>();

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Pressure> getPressures() {
        return pressures;
    }

    public ArrayList<Health> getHealth() {
        return health;
    }

    public void setHealth(ArrayList<Health> health) {
        this.health = health;
    }

    public void setPressures(ArrayList<Pressure> pressures) {
        this.pressures = pressures;
    }
}
