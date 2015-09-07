//The library management application that delegates the things in the specifications
package com.tw.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {


    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
    }

    public void start() {
        WelcomeMessage welcomeMessage = new WelcomeMessage();
        welcomeMessage.display();
        ArrayList<String> menuOptions = new ArrayList<>();
        menuOptions.add("1. List Books");
        menuOptions.add("2. Quit");
        Menu menu = new Menu(menuOptions);
        int choice = menu.getChoice();

        if(choice == 1) {
            ArrayList<BookInfo> bookInfoArrayList = new ArrayList<BookInfo>();
            bookInfoArrayList.add(new BookInfo("Harry Potter", "J K Rowling", "2001"));
            bookInfoArrayList.add(new BookInfo("To Kill A Mockingbird", "Harper Lee", "1970"));
            bookInfoArrayList.add(new BookInfo("A Brief History Of Time", "Stephen Hawking", "1988"));
            BookInfoList bookInfoList = new BookInfoList(bookInfoArrayList);
            bookInfoList.printList();
        }
        else if(choice ==2) {
            System.out.println("exiting");
            System.exit(0);
        }
    }
}