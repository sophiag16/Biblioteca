//has a list of options and reads a choice from user
package com.tw.biblioteca;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private ArrayList<String> menuOptions = new ArrayList<>();

    public Menu(User currentUser) {
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
    }

    public String chosenOption() {
        System.out.println(StringUtils.join(menuOptions, "\n"));
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
