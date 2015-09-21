//delegates execution according to the option chosen by user
package com.tw.biblioteca;

import java.util.Scanner;

public class Controller {
    private String chosenOption;
    private Library library;
    private Authenticator authenticator;
    private User currentUser;

    public Controller(String chosenOption, Library library, Authenticator authenticator, User currentUser) {
        this.chosenOption = chosenOption;
        this.library = library;
        this.authenticator = authenticator;
        this.currentUser = currentUser;
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
                printString("You need to login for this\n");
                }
                else {
                    new LibraryController(library).issueBook(currentUser);
                }
                break;
            case "4":
                if(currentUser.role().equals("guest")) {
                    printString("You need to login for this\n");
                }
                else {
                    new LibraryController(library).returnBook(currentUser);
                }
                break;
            case "5":
                library.printMovies();
                break;
            case "6":
                new LibraryController(library).issueMovie();
                break;
            case "7":
                if(currentUser.role().equals("guest")) {
                    LoginInterface loginInterface = new LoginInterface(new Scanner(System.in));
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
                    printString("Invalid option\n");
                }
                break;
            default:
                printString("Invalid option\n");
        }
        return currentUser;
    }

    private void printString(String stringToPrint) {
        System.out.print(stringToPrint);
    }

}
