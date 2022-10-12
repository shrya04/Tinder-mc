package com.practice.app.tinder.service;

import com.practice.app.tinder.models.User;
import com.practice.app.tinder.repository.UserRepository;

public class UserService {

    UserRepository userRepository = new UserRepository();

    public void createUser(String user, int x, int y, int age, String gender) {
        if(user ==null || gender == null) {
            throw new RuntimeException("invalid input");
        }
        userRepository.addUser(new User(user, x, y, age, gender));
        System.out.println("User added :" + user);
    }

    public User getUser(String user) {
        return userRepository.getUser(user);
    }
}
