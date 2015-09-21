//prints the string passed to it
package com.tw.biblioteca;

import java.io.PrintStream;

public class Display {
    private PrintStream printStream;

    public Display(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printString(String stringToPrint) {
        printStream.print(stringToPrint);
    }
}
