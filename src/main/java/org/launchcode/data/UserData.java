package org.launchcode.data;

import org.launchcode.models.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserData {

    private static List<User> users = new ArrayList<>();

    public static void add(User user) {
        users.add(user);
    }

    public static User getById(Integer id) {
        return users.get(id);
    }

    public static Collection<User> getAll() {
        return users;
    }

}
