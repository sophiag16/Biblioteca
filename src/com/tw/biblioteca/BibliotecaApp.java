//The library management application that delegates the things in the specifications
package com.tw.biblioteca;

public class BibliotecaApp {
    private Library library = new Library();

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
    }

    public void start() {
        WelcomeMessage welcomeMessage = new WelcomeMessage();
        welcomeMessage.display();
        do {
            Menu menu = new Menu();
            TaskDispatcher taskDispatcher = new TaskDispatcher(menu.chosenValidOption(), library);
            taskDispatcher.dispatch();
        }while(true);
    }
}