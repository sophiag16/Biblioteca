//accepts library number and password from user
package com.tw.biblioteca;

import java.util.Scanner;

public class LoginInterface {
    Scanner scanner;

    public LoginInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public String libraryNumber() {
        System.out.println("Enter your library number: ");
        return scanner.nextLine();
    }

    public String password() {
        System.out.println("Enter your password: ");
        return scanner.nextLine();
    }
}
