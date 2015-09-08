//reads choice from user
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
    }

    public int chosenOption() {
        int choice = 0;
        do {
            System.out.println(StringUtils.join(menuOptions, "\n"));
            try {
                Scanner scanner = new Scanner(System.in);
                choice = scanner.nextInt();
            } catch (Exception e) {
            }
        } while (!isChoiceValid(choice));
        return choice;
    }

    private boolean isChoiceValid(int choice) {
        for (int i = 1; i <= menuOptions.size(); i++) {
            if (choice == i)
                return true;
        }
        System.out.println("Invalid option");
        return false;
    }
}
