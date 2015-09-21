//accepts library number and password from user
package com.tw.biblioteca;

import java.util.Scanner;

public class LoginInterface {
    private Scanner scanner;
    private Display display;

    public LoginInterface(Scanner scanner, Display display) {
        this.scanner = scanner;
        this.display = display;
    }

    public String libraryNumber() {
        display.printString("Enter your library number: \n");
        return scanner.nextLine();
    }

    public String password() {
        display.printString("Enter your password: \n");
        return scanner.nextLine();
    }
}
