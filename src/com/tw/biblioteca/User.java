//has user details and compares given details with its own
package com.tw.biblioteca;

public class User {
    private String libraryNumber;
    private String password;
    private String role;
    private String name;
    private String email;
    private String phone;
    private static final String defaultLibraryNumber = "";
    private static final String defaultPassword = "";

    public User() {
        this.libraryNumber = defaultLibraryNumber;
        this.password = defaultPassword;
        this.role = "guest";
        this.name = "";
        this.email = "";
        this.phone = "";
    }

    public User(String libraryNumber, String password, String role, String name, String email, String phone) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.role = role;
        this.name = name;
        this.email = email;
        this.phone = phone;
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
        return (this.password.equals(password));
    }

    public String role() {
        return role;
    }

    public void printLibraryNumber() {
        System.out.print(libraryNumber);
    }

    public void printInfo() {
        System.out.print("Name: " + name +
                            "\nEmail: " + email +
                            "\nPhone: " + phone + "\n");
    }
}
