//reads choice from user
package com.tw.biblioteca;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private ArrayList<String> menuOptions = new ArrayList<>();

    public Menu(ArrayList menuOptions) {
        this.menuOptions = menuOptions;
    }

    public int getChoice() {
        int choice = 0;
        do {
            System.out.println(StringUtils.join(menuOptions, "\n"));
            try {
                Scanner scanner = new Scanner(System.in);
                choice = scanner.nextInt();
            } catch (Exception e) {
            }
        }while(!isValid(choice));
        return choice;
    }

    private boolean isValid(int choice) {
        for(int i = 1; i <= menuOptions.size(); i++) {
            if(choice == i)
                return true;
        }
        System.out.println("Invalid option");
        return false;
    }
}
