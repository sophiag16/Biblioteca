//has a set of valid users and verifies if the library number and password given to it are valid
package com.tw.biblioteca;

import java.util.ArrayList;

public class Authenticator {
    private ArrayList<User> userArrayList = new ArrayList<User>();

    public Authenticator() {
        userArrayList.add(new User("111-1111", "abcxyz"));
        userArrayList.add(new User("222-2222", "123456"));
    }

    public boolean isValid(String libraryNumber, String password) {
        User user = new User(libraryNumber, "");
        if(userArrayList.contains(user)) {
            return userArrayList.get(userArrayList.indexOf(user)).checkPassword(password);
        }
        return false;
    }
}