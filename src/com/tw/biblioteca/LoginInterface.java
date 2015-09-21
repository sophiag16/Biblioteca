//accepts library number and password from user
package com.tw.biblioteca;

import java.util.Scanner;

public class LoginInterface {
    Scanner scanner;

    public LoginInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public String libraryNumber() {
        printString("Enter your library number: \n");
        return scanner.nextLine();
    }

    public String password() {
        printString("Enter your password: \n");
        return scanner.nextLine();
    }

    private void printString(String stringToPrint) {
        System.out.println(stringToPrint);
    }

}
