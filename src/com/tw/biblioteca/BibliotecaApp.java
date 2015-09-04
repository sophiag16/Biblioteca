//The library management application that
package com.tw.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
    }

    public void start() {
        WelcomeMessage welcomeMessage = new WelcomeMessage();
        welcomeMessage.display();
        System.out.println("Name\tAuthor\tYear of Publishing");
        BookInfo bookInfo1 = new BookInfo("Harry Potter", "J K Rowling", "2001");
        bookInfo1.printBookInfo();
        BookInfo bookInfo2 = new BookInfo("To Kill A Mockingbird", "Harper Lee", "1970");
        bookInfo2.printBookInfo();
        BookInfo bookInfo3 = new BookInfo("A Brief History Of Time", "Stephen Hawking", "1988");
        bookInfo3.printBookInfo();
    }
}