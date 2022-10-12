package com.practice.app.tinder.comparator;

import com.practice.app.tinder.utils.pojos.UserDiff;

import java.util.Comparator;

public class DistanceComparator implements Comparator<UserDiff> {

        @Override
        public int compare(UserDiff o1, UserDiff o2) {
                return Math.round(o1.getDistanceDiff()-o2.getDistanceDiff());
        }

        @Override
        public boolean equals(Object obj) {
                return false;
        }
}
