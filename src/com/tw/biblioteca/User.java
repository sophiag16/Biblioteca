//has user details and compares given details with its own
package com.tw.biblioteca;

public class User {
    private String libraryNumber;
    private String password;
    private String role;
    private static final String defaultLibraryNumber = "";
    private static final String defaultPassword = "";

    public User() {
        this.libraryNumber = defaultLibraryNumber;
        this.password = defaultPassword;
        this.role = "guest";
    }

    public User(String libraryNumber, String password, String role) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.role = role;
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

    public String role() {
        return role;
    }
}
