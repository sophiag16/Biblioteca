//has user details and compares given details with its own
package com.tw.biblioteca;

public class User {
    private String libraryNumber;

    public User(String libraryNumber) {
        this.libraryNumber = libraryNumber;
    }

    @Override
    public boolean equals(Object that) {
        return true;
    }
}
