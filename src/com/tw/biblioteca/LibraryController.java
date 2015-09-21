//controls the issue and return of books of library
package com.tw.biblioteca;

import java.util.Scanner;

public class LibraryController {
    private Library library;
    private Display display;

    public LibraryController(Library library, Display display) {
        this.display = display;
        this.library = library;
    }

    public void issueBook(User currentUser) {
        display.printString("Enter the name of book to be issued\n");
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.nextLine();
        if(library.removeBook(bookName, currentUser))
            display.printString("Thank you! Enjoy the book\n");
        else
            display.printString("That book is not available\n");
    }

    public void returnBook(User currentUser) {
        display.printString("Enter the name of book to return\n");
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.nextLine();
        if(library.addBook(bookName, currentUser))
            display.printString("Thank you for returning the book.\n");
        else
            display.printString("That is not a valid book to return.\n");

    }

    public void issueMovie() {
        display.printString("Enter the name of movie to be issued\n");
        Scanner scanner = new Scanner(System.in);
        String movieName = scanner.nextLine();
        if(library.removeMovie(movieName))
            display.printString("Thank you! Enjoy the movie\n");
        else
            display.printString("That movie is not available\n");
    }
}
