//controls the issue and return of books of library
package com.tw.biblioteca;

import java.util.Scanner;

public class LibraryController {
    private Library library = new Library();

    public LibraryController(Library library) {
        this.library = library;
    }

    public void issueBook(User currentUser) {
        printString("Enter the name of book to be issued\n");
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.nextLine();
        if(library.removeBook(bookName, currentUser))
            printString("Thank you! Enjoy the book\n");
        else
            printString("That book is not available\n");
    }

    public void returnBook(User currentUser) {
        printString("Enter the name of book to return\n");
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.nextLine();
        if(library.addBook(bookName, currentUser))
            printString("Thank you for returning the book.\n");
        else
            printString("That is not a valid book to return.\n");

    }

    public void issueMovie() {
        printString("Enter the name of movie to be issued\n");
        Scanner scanner = new Scanner(System.in);
        String movieName = scanner.nextLine();
        if(library.removeMovie(movieName))
            printString("Thank you! Enjoy the movie\n");
        else
            printString("That movie is not available\n");
    }

    private void printString(String stringToPrint) {
        System.out.print(stringToPrint);
    }

}
