//has a set of valid users and verifies if the library number and password given to it are valid
package com.tw.biblioteca;

import java.util.ArrayList;

public class Authenticator {
    private ArrayList<User> userArrayList = new ArrayList<User>();

    public Authenticator() {
        userArrayList.add(new User("111-1111"));
        userArrayList.add(new User("222-2222"));
    }

    public boolean isValid(String libraryNumber) {
        User user = new User(libraryNumber);
        return userArrayList.contains(user);
    }
}