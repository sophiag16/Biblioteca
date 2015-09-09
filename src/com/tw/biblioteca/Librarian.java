package com.tw.biblioteca;

import java.util.Scanner;

public class Librarian {
    private Library library = new Library();

    public Librarian(Library library) {
        this.library = library;
    }

    public void checkout() {
        System.out.println("Enter the name of book to checkout");
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.nextLine();
        if(library.remove(bookName))
            System.out.println("Thank you! Enjoy the book");
        else
            System.out.println("That book is not available");
    }
}
