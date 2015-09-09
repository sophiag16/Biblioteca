//executes the option chosen by user
package com.tw.biblioteca;

public class TaskDispatcher {
    private int chosenOption;
    private Library library;

    public TaskDispatcher(int chosenOption, Library library) {
        this.chosenOption = chosenOption;
        this.library = library;
    }


    public void dispatch() {
        switch (chosenOption) {
            case 1:
                library.printList();
                break;
            case 2:
                System.exit(0);
            case 3:
                new Librarian(library).issueBook();
                break;
        }
    }
}
