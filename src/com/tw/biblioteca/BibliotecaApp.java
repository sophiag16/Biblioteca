//The library management application that delegates the things in the specifications
package com.tw.biblioteca;

public class BibliotecaApp {


    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
    }

    public void start() {
        WelcomeMessage welcomeMessage = new WelcomeMessage();
        welcomeMessage.display();
        BookInfoList bookInfoList = new BookInfoList();
        bookInfoList.printList();
    }
}