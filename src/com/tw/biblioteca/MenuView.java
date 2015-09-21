//has a list of options and reads a choice from user
package com.tw.biblioteca;

import com.sun.deploy.util.StringUtils;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuView {
    private ArrayList<String> menuOptions;
    private Display display;

    public MenuView(ArrayList<String> menuOptions, Display display) {
        this.display = display;
        this.menuOptions = menuOptions;
    }

    public String readInput() {
        display.printString(StringUtils.join(menuOptions, "\n") + "\n");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
