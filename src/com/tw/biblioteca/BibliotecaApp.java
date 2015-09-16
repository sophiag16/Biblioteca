//The library management application that delegates the things in the specifications
package com.tw.biblioteca;

public class BibliotecaApp {
    private Library library = new Library();
    private Menu menu = new Menu();
    private Authenticator authenticator = new Authenticator();

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
    }

    public void start() {
        WelcomeMessage welcomeMessage = new WelcomeMessage();
        welcomeMessage.display();
        do {
            String choice = menu.chosenOption();
            TaskDispatcher taskDispatcher = new TaskDispatcher(choice, library, menu, authenticator);
            taskDispatcher.dispatch();
        }while(true);
    }
}