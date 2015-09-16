//delegates execution according to the option chosen by user
package com.tw.biblioteca;

import java.util.Scanner;

public class TaskDispatcher {
    private String chosenOption;
    private Library library;
    private Menu menu;
    private Authenticator authenticator;

    public TaskDispatcher(String chosenOption, Library library, Menu menu, Authenticator authenticator) {
        this.chosenOption = chosenOption;
        this.library = library;
        this.menu = menu;
        this.authenticator = authenticator;
    }


    public void dispatch() {
        switch (chosenOption) {
            case "1":
                library.printBooks();
                break;
            case "2":
                System.exit(0);
            case "3":
                new LibraryController(library).issueBook();
                break;
            case "4":
                new LibraryController(library).returnBook();
                break;
            case "5":
                library.printMovies();
                break;
            case "6":
                new LibraryController(library).issueMovie();
                break;
            case "7":
                LoginInterface loginInterface = new LoginInterface(new Scanner(System.in));
                authenticator.isValid(loginInterface.libraryNumber(), loginInterface.password());
                break;
            default:
                System.out.println("Invalid option");
        }
    }
}
