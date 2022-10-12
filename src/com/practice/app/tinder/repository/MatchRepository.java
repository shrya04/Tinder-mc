package com.practice.app.tinder.repository;

import com.practice.app.tinder.exceptions.NoMatchExistsException;
import com.practice.app.tinder.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MatchRepository {

    static HashMap<User, List<User>> matches = new HashMap<>();
    static HashMap<User, List<User>> ignores = new HashMap<>();

    public static void addMatch(User userOne, User userTwo) {
        if(matches.containsKey(userOne)) {
            List<User> matchesOne = matches.get(userOne);
            matchesOne.add(userTwo);
            matches.put(userOne, matchesOne);
        } else {
            List<User> matchesOne = new ArrayList<>();
            matchesOne.add(userTwo);
            matches.put(userOne, matchesOne);
        }
        if(matches.containsKey(userTwo)) {
            List<User> matchesTwo = matches.get(userTwo);
            matchesTwo.add(userOne);
            matches.put(userTwo, matchesTwo);
        } else {
            List<User> matchesTwo = new ArrayList<>();
            matchesTwo.add(userOne);
            matches.put(userTwo, matchesTwo);
        }
    }

    public static void addIgnoreMatch(User userOne, User userTwo) {
        if(ignores.containsKey(userOne)) {
            List<User> matchesOne = ignores.get(userOne);
            matchesOne.add(userTwo);
            ignores.put(userOne, matchesOne);
        } else {
            List<User> matchesOne = new ArrayList<>();
            matchesOne.add(userTwo);
            ignores.put(userOne, matchesOne);
        }
    }

    public static List<User> getMatch(User user) {
        if(matches.containsKey(user)) {
            return matches.get(user);
        } else {
            throw new NoMatchExistsException();
        }
    }

    public static HashMap<User, List<User>> getAllMatches() {
        return matches;
    }

    public static List<User> getIgnored(User user) {
        if(ignores.containsKey(user)) {
            return ignores.get(user);
        } else {
            return new ArrayList<>();
        }
    }
}
