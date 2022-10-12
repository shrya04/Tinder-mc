package com.practice.app.tinder.utils;

import com.practice.app.tinder.models.Location;

public class Utils {

    public static Float getDistanceDiff(Location one, Location two) {
        return getDistanceDiff(one.getX(), one.getY(), two.getX(), two.getY());
    }

    public static Float getDistanceDiff(int x1, int y1, int x2, int y2) {
        double x = (x1-x2)*(x1-x2);
        double y = ((y1-y2)*(y1-y2));
        return (float) Math.sqrt(x + y);
    }

    public static int getAgeDiff(int age1, int age2) {
        return Math.abs(age1-age2);
    }
}
