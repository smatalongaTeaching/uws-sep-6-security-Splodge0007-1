package com.uws.secureprogramming.dataLeak;

import java.util.ArrayList;

public class UserDatabase {
    ArrayList<User> database;

    public UserDatabase() {
        database = new ArrayList<>();
    }   

    public void addUser(User user) {
        if (user != null && !database.contains(user)) {
            database.add(user);
        }
    }

    public boolean userExists(User user) {
        return database.contains(user);
    }

    public boolean AcceptUserLogin(String username, String password) {
        for (User user : database) {
            if (user.getName().equals(username) && user.getPassword().equals(password)) {
                return true; // User found with matching username and password
            }
        }
        return false; // No matching user found
    }
}
