//has a list of options and reads a choice from user
package com.tw.biblioteca;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private ArrayList<String> menuOptions = new ArrayList<>();

    public Menu() {
        menuOptions.add("1. List Books");
        menuOptions.add("2. Quit");
        menuOptions.add("3. Checkout Book");
        menuOptions.add("4. Return Book");
        menuOptions.add("5. List Movies");
    }

    public String chosenOption() {
        System.out.println(StringUtils.join(menuOptions, "\n"));
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
