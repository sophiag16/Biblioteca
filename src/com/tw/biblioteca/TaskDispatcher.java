//executes the option chosen by user
package com.tw.biblioteca;

public class TaskDispatcher {
    private int chosenOption;

    public TaskDispatcher(int chosenOption, BookInfoList bookInfoList) {
        this.chosenOption = chosenOption;
    }


    public void dispatch() {
        switch (chosenOption) {
            case 1:
                BookInfoList bookInfoList = new BookInfoList();
                bookInfoList.printList();
                break;
            case 2:
                System.exit(0);
                break;
            case 3:
                break;
        }
    }
}
