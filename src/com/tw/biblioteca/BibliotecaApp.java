//The library management application that delegates the things in the specifications
package com.tw.biblioteca;

public class BibliotecaApp {
    private Library library = new Library();
    private Menu menu;
    private Authenticator authenticator = new Authenticator();
    private User currentUser = new User();

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
    }

    public void start() {
        WelcomeMessage welcomeMessage = new WelcomeMessage();
        welcomeMessage.display();
        do {
            String choice = new Menu(currentUser).chosenOption();
            TaskDispatcher taskDispatcher = new TaskDispatcher(choice, library, authenticator, currentUser);
            currentUser = taskDispatcher.dispatch();
        }while(true);
    }
}