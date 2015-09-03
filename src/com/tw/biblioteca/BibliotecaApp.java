//The library management application that wraps
package com.tw.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
    }

    public void start() {
        System.out.println("Welcome to Biblioteca");
        System.out.print("Name \tAuthor \tYear of Publishing\n" +
                "Harry Potter \tJ K Rowling \t2001\n" +
                "To Kill A Mockingbird \tHarper Lee \t1970\n" +
                "A Brief History Of Time \tStephen Hawking \t1988");
    }
}
