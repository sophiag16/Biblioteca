package com.tw.biblioteca;

import java.util.Scanner;

public class Librarian {
    private BookInfoList bookInfoList = new BookInfoList();

    public Librarian(BookInfoList bookInfoList) {
        this.bookInfoList = bookInfoList;
    }

    public void checkout() {
        System.out.println("Enter the name of book to checkout");
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.nextLine();
        if(bookInfoList.remove(bookName))
            System.out.println("Thank you! Enjoy the book");
        else
            System.out.println("That book is not available");
    }

    public void returnBook() {
        System.out.println("Enter the name of book to return");
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.nextLine();
        if(bookInfoList.remove(bookName))
            System.out.println("Thank you! Enjoy the book");
        else
            System.out.println("That book is not available");
    }
}
