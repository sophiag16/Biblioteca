package com.tw.biblioteca;

import java.util.ArrayList;

public class MenuFactory {
    private User currentUser;

    public MenuFactory(User currentUser) {
        this.currentUser = currentUser;
    }

    public ArrayList<String> createMenu() {
        ArrayList<String> menuOptions = new ArrayList<String>();

        menuOptions.add("1. List Books");
        menuOptions.add("2. Quit");
        menuOptions.add("3. Checkout Book");
        menuOptions.add("4. Return Book");
        menuOptions.add("5. List Movies");
        menuOptions.add("6. Checkout Movie");

        if (currentUser.role().equals("guest")) {
            menuOptions.add("7. Login");
        }
        else {
            menuOptions.add("7. Logout");
        }

        if (currentUser.role().equals("admin")) {
            menuOptions.add("8. Show Book Details");
        }
        else if(currentUser.role().equals("user")) {
            menuOptions.add("8. Show User Details");
        }

        return menuOptions;
    }
}
