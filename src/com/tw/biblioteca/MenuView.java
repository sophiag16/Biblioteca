//has a list of options and reads a choice from user
package com.tw.biblioteca;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuView {
    private ArrayList<String> menuOptions;

    public MenuView(ArrayList<String> menuOptions) {
        this.menuOptions = menuOptions;
    }

    public String readInput() {
        printString(StringUtils.join(menuOptions, "\n") + "\n");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void printString(String stringToPrint) {
        System.out.print(stringToPrint);
    }

}
