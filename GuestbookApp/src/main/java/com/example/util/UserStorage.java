package com.example.util;
import com.example.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserStorage {
    private static List<User> users = new ArrayList<>();

    public static void addUser(User user) {
        users.add(user);
    }

    public static List<User> getUsers() {
        return new ArrayList<>(users); // Return copy to avoid modification
    }
}