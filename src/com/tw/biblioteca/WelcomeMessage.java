//has a welcome message and displays it
package com.tw.biblioteca;

public class WelcomeMessage {
    private String welcomeMessage = "Welcome to Biblioteca\n";
    private Display display;

    public WelcomeMessage(Display display) {
        this.display = display;
    }

    public void display() {
        display.printString(welcomeMessage);
    }
}