//The library management application that delegates the things in the specifications
package com.tw.biblioteca;

public class BibliotecaApp {
    private BookInfoList bookInfoList = new BookInfoList();

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
    }

    public void start() {
        WelcomeMessage welcomeMessage = new WelcomeMessage();
        welcomeMessage.display();
        do {
            Menu menu = new Menu();
            int choice = menu.chosenOption();
            TaskDispatcher taskDispatcher = new TaskDispatcher(choice, bookInfoList);
            taskDispatcher.dispatch();
        }while(true);
    }
}