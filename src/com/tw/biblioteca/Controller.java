//delegates execution according to the option chosen by user
package com.tw.biblioteca;

import java.io.PrintStream;
import java.util.Scanner;

public class Controller {
    private String chosenOption;
    private Library library;
    private Authenticator authenticator;
    private User currentUser;
    private Display display;

    public Controller(String chosenOption, Library library, Authenticator authenticator, User currentUser, Display display) {
        this.chosenOption = chosenOption;
        this.library = library;
        this.authenticator = authenticator;
        this.currentUser = currentUser;
        this.display = display;
    }


    public User dispatch() {
        switch (chosenOption) {
            case "1":
                library.printBooks();
                break;
            case "2":
                System.exit(0);
            case "3":
                if(currentUser.role().equals("guest")) {
                display.printString("You need to login for this\n");
                }
                else {
                    new LibraryController(library, new Display(new PrintStream(System.out))).issueBook(currentUser);
                }
                break;
            case "4":
                if(currentUser.role().equals("guest")) {
                    display.printString("You need to login for this\n");
                }
                else {
                    new LibraryController(library, new Display(new PrintStream(System.out))).returnBook(currentUser);
                }
                break;
            case "5":
                library.printMovies();
                break;
            case "6":
                new LibraryController(library, new Display(new PrintStream(System.out))).issueMovie();
                break;
            case "7":
                if(currentUser.role().equals("guest")) {
                    LoginInterface loginInterface = new LoginInterface(new Scanner(System.in), new Display(new PrintStream(System.out)));
                    currentUser = authenticator.isValid(loginInterface.libraryNumber(), loginInterface.password());
                }
                else
                    currentUser = new User();
                break;
            case "8":
                if(currentUser.role().equals("admin")) {
                    library.printBookInfo();
                }
                else if(currentUser.role().equals("user"))
                {
                    currentUser.printInfo();
                }
                else {
                    display.printString("Invalid option\n");
                }
                break;
            default:
                display.printString("Invalid option\n");
        }
        return currentUser;
    }
}
