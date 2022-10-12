package com.practice.app.tinder.service;

import com.practice.app.tinder.comparator.AgeComparator;
import com.practice.app.tinder.comparator.DistanceComparator;
import com.practice.app.tinder.enums.GENDER;
import com.practice.app.tinder.models.User;
import com.practice.app.tinder.repository.MatchRepository;
import com.practice.app.tinder.repository.UserRepository;
import com.practice.app.tinder.utils.Utils;
import com.practice.app.tinder.utils.pojos.UserDiff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchService {

     void getMatchesForUser(String userName){
         User user = UserRepository.getUser(userName);

         List<User> potentialMatches = getFilteredList(user);
         List<UserDiff> potentialUserList = new ArrayList<>();
         for(User matches: potentialMatches) {
             float distance = Utils.getDistanceDiff(user.getLocation(), matches.getLocation());
             int ageDiff = Utils.getAgeDiff(user.getAge(), matches.getAge());
             potentialUserList.add(new UserDiff(matches, ageDiff, distance));
         }

         potentialUserList.sort(new DistanceComparator());
         potentialUserList.sort(new AgeComparator());
         System.out.println("Potential matches for user: "+userName);
         for(User matches: potentialMatches) {
             System.out.println("User "+matches.getName());
         }
     }

     void addMatch(String u1, String u2) {
         User userOne = UserRepository.getUser(u1);
         User userTwo = UserRepository.getUser(u2);
         MatchRepository.addMatch(userOne, userTwo);
         System.out.println("Match added");
     }

    public void ignoreMatch(String u1, String u2) {
        User userOne = UserRepository.getUser(u1);
        User userTwo = UserRepository.getUser(u2);
        MatchRepository.addIgnoreMatch(userOne, userTwo);
    }

    public void showMatches(String u1) {
        User user = UserRepository.getUser(u1);
        List<User> matches = MatchRepository.getMatch(user);
        for(User match: matches) {
            System.out.println("Match of user "+ u1  + " is user: "+ match.getName());
        }
    }

    public void showAllMatches() {
        HashMap<User, List<User>> matches = MatchRepository.getAllMatches();
        for (Map.Entry<User,List<User>> mapElement : matches.entrySet()) {
            System.out.println("Matches of user : " + mapElement.getKey().getName());
            mapElement.getValue().forEach(match -> System.out.println("Name: "+ match.getName()));
        }
    }
    private List<User>getFilteredList(User user) {
        GENDER matchGender = user.getGender() == GENDER.MALE ? GENDER.FEMALE : GENDER.MALE;
        List<User> potentialMatches = UserRepository.getUsersByGender(matchGender);

        List<User> alreadyMatches = MatchRepository.getMatch(user);
        List<User> alreadyIgnored = MatchRepository.getIgnored(user);

        potentialMatches.stream().filter(e-> alreadyMatches.contains(e)).filter(e-> alreadyIgnored.contains(e));

        return potentialMatches;

    }
}
