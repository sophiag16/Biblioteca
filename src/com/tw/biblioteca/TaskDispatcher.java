//executes the option chosen by user
package com.tw.biblioteca;

public class TaskDispatcher {
    private int chosenOption;
    private BookInfoList bookInfoList;

    public TaskDispatcher(int chosenOption, BookInfoList bookInfoList) {
        this.chosenOption = chosenOption;
        this.bookInfoList = bookInfoList;
    }


    public void dispatch() {
        switch (chosenOption) {
            case 1:
                bookInfoList.printList();
                break;
            case 2:
                System.exit(0);
            case 3:
                Librarian librarian = new Librarian(bookInfoList);
                librarian.checkout();
        }
    }
}
