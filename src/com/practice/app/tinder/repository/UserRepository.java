package com.practice.app.tinder.repository;

import com.practice.app.tinder.enums.GENDER;
import com.practice.app.tinder.exceptions.UserAlreadyExistsException;
import com.practice.app.tinder.exceptions.UserDoesntExistException;
import com.practice.app.tinder.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {

    static HashMap<String, User> userReposiory = new HashMap<>();


    public void addUser(User user) {
        if(userReposiory.containsKey(user.getName())){
            throw new UserAlreadyExistsException();
        }
        userReposiory.put(user.getName(), user);
    }

    public static User getUser(String user) {
        if(!userReposiory.containsKey(user)){
            throw new UserDoesntExistException();
        }
        return userReposiory.get(user);
    }

    public static List<User> getUsersByGender(GENDER gender) {
        List<User> users = new ArrayList<>();
        for (Map.Entry<String,User> entry : userReposiory.entrySet()){
            if(entry.getValue().getGender().equals(gender)){
                users.add(entry.getValue());
            }
        }
        return users;
    }
}
