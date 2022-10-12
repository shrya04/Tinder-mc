package com.practice.app.tinder.utils.pojos;

import com.practice.app.tinder.models.User;

public class UserDiff {
    User user;
    Integer ageDiff;
    Float distanceDiff;

    public UserDiff(User user, Integer ageDiff, Float diff) {
        this.user = user;
        this.ageDiff = ageDiff;
        this.distanceDiff = diff;
    }

    public Integer getAgeDiff() {
        return ageDiff;
    }

    public void setAgeDiff(Integer ageDiff) {
        this.ageDiff = ageDiff;
    }

    public Float getDistanceDiff() {
        return distanceDiff;
    }

    public void setDistanceDiff(Float distanceDiff) {
        this.distanceDiff = distanceDiff;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
