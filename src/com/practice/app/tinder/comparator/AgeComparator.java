package com.practice.app.tinder.comparator;

import com.practice.app.tinder.models.User;
import com.practice.app.tinder.utils.pojos.UserDiff;

import java.util.Comparator;

public class AgeComparator implements Comparator<UserDiff> {

    @Override
    public int compare(UserDiff o1, UserDiff o2) {
        return o1.getAgeDiff()-o2.getAgeDiff();
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
