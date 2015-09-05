//reads choice from user
package com.tw.biblioteca;

import java.util.Scanner;

public class Menu {
    private String menuList;

    public Menu(String menuList) {
        this.menuList = menuList;
    }

    public int getChoice() {
        System.out.println(menuList);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
