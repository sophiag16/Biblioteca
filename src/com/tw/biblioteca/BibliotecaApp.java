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
        Menu menu = new Menu();
        int choice = menu.chosenOption();

        if (choice == 1) {
            BookInfoList bookInfoList = new BookInfoList();
            bookInfoList.printList();
        } else if (choice == 2) {
            System.out.println("exiting");
            System.exit(0);
        }
    }
}