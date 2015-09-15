//has user details and compares given details with its own
package com.tw.biblioteca;

public class User {
    private String libraryNumber;

    public User(String libraryNumber) {
        this.libraryNumber = libraryNumber;
    }

    @Override
    public boolean equals(Object that) {
        if (!(that instanceof User)) {
            return false;
        }
        if(this == that)
            return true;
        User thatUser = (User) that;
        if(this.libraryNumber.equals(((User) that).libraryNumber)) {
            return true;
        }
        return false;
    }
}
