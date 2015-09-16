//has user details and compares given details with its own
package com.tw.biblioteca;

public class User {
    private String libraryNumber;
    private String password;

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    @Override
    public boolean equals(Object that) {
        if (!(that instanceof User)) {
            return false;
        }
        if(this == that)
            return true;
        User thatUser = (User) that;
        if(this.libraryNumber.equals(thatUser.libraryNumber)) {
            return true;
        }
        return false;
    }

    public boolean checkPassword(String password) {
        return this.password == password;
    }
}
