package com.practice.app.tinder;

import com.practice.app.tinder.service.TinderService;

public class Driver {
    public static void main(String args[]) {
        TinderService tinderService = new TinderService();
        tinderService.createAccount("user_A",  2, 3, 23, "M");
        tinderService.createAccount("user_B", 3, 4, 45, "F");
        tinderService.createAccount("user_C", 4, 6, 32, "F");
        tinderService.createAccount("user_D", 7, 8, 23, "m");
        tinderService.potentialMatch("user_A");
        tinderService.addMatch("user_A", "user_C");
        tinderService.ignore("user_A","user_B");
        tinderService.showMatches("user_A");
        tinderService.showMatches("user_C");
        tinderService.showAllMatches();
    }
}
