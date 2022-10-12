package com.practice.app.tinder.service;

public class TinderService {

    UserService userService = new UserService();
    MatchService matchService = new MatchService();

    public void createAccount(String user, int x, int y, int age, String gender) {
        userService.createUser(user, x, y, age, gender);
    }

    public void potentialMatch(String user) {
        matchService.getMatchesForUser(user);
    }

    public void addMatch(String u1, String u2) {
        matchService.addMatch(u1, u2);
    }

    public void ignore(String userA, String userB) {
        matchService.ignoreMatch(userA, userB);
    }

    public void showMatches(String user) {
        matchService.showMatches(user);
    }

    public void showAllMatches(){
        matchService.showAllMatches();
    }
}
