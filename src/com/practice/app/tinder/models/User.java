package com.practice.app.tinder.models;

import com.practice.app.tinder.enums.GENDER;

public class User {
    private String name;
    private Location location;
    private int age;
    private GENDER gender;

    public User(String name, int x, int y, int age, String gender) {
        this.name = name;
        this.location = new Location(x,y);
        this.age = age;
        this.gender = gender.equalsIgnoreCase("M") ?  GENDER.MALE : GENDER.FEMALE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public GENDER getGender() {
        return gender;
    }

    public void setGender(GENDER gender) {
        this.gender = gender;
    }
}
