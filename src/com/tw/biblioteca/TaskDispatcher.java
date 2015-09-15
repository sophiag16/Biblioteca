//delegates execution according to the option chosen by user
package com.tw.biblioteca;

public class TaskDispatcher {
    private String chosenOption;
    private Library library;
    private Menu menu;

    public TaskDispatcher(String chosenOption, Library library, Menu menu) {
        this.chosenOption = chosenOption;
        this.library = library;
        this.menu = menu;
    }


    public void dispatch() {
        switch (chosenOption) {
            case "1":
                library.printBooks();
                break;
            case "2":
                System.exit(0);
            case "3":
                new LibraryController(library).issueBook();
                break;
            case "4":
                new LibraryController(library).returnBook();
                break;
            case "5":
                library.printMovies();
                break;
            default:
                System.out.println("Invalid option");
                String choice = menu.chosenOption();
                TaskDispatcher taskDispatcher = new TaskDispatcher(choice, library, menu);
                taskDispatcher.dispatch();
        }
    }
}
