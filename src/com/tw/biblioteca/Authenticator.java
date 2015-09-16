//has a set of valid users and verifies if the library number and password given to it are valid
package com.tw.biblioteca;

import java.util.ArrayList;

public class Authenticator {
    private ArrayList<User> userArrayList = new ArrayList<User>();

    public Authenticator() {
        userArrayList.add(new User("111-1111", "abcxyz", "user"));
        userArrayList.add(new User("222-2222", "123456", "user"));
        userArrayList.add(new User("000-0000", "secret", "admin"));
    }

    public User isValid(String libraryNumber, String password) {
        User user = new User(libraryNumber, "", "");
        if(userArrayList.contains(user) && userArrayList.get(userArrayList.indexOf(user)).checkPassword(password)) {
            return userArrayList.get(userArrayList.indexOf(user));
        }
        return new User();
    }
}