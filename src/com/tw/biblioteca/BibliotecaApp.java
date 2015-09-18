//The library management application that delegates the things in the specifications
package com.tw.biblioteca;

public class BibliotecaApp {
    private Library library = new Library();
    private MenuView menuView;
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
            String choice = new MenuView(new MenuFactory(currentUser).createMenu()).readInput();
            Controller controller = new Controller(choice, library, authenticator, currentUser);
            currentUser = controller.dispatch();
        }while(true);
    }
}