package com.practice.app.tinder.models;

public class Location {
    Integer x;
    Integer y;

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Location(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }
}

