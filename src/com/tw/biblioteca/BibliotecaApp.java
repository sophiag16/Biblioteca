//The library management application that delegates the things in the specifications
package com.tw.biblioteca;

import java.io.PrintStream;

public class BibliotecaApp {
    private MenuView menuView;
    private Authenticator authenticator = new Authenticator();
    private User currentUser = new User();
    Display display = new Display(new PrintStream(System.out));
    private Library library = new Library(display);

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
    }

    public void start() {
        WelcomeMessage welcomeMessage = new WelcomeMessage(display);
        welcomeMessage.display();
        do {
            String choice = new MenuView(new MenuFactory(currentUser).createMenu(), new Display(new PrintStream(System.out))).readInput();
            Controller controller = new Controller(choice, library, authenticator, currentUser, display);
            currentUser = controller.dispatch();
        }while(true);
    }
}