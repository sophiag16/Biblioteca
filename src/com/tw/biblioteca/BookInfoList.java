//has a list of book-information and displays it
package com.tw.biblioteca;

import java.util.ArrayList;

public class BookInfoList {
    ArrayList<BookInfo> bookInfoArrayList = new ArrayList<BookInfo>();

    public BookInfoList(ArrayList bookInfoArrayList) {
        this.bookInfoArrayList = bookInfoArrayList;
    }

    public void printList() {
        System.out.print("Name\tAuthor\tYear of Publishing\n");
        bookInfoArrayList.get(0).printInfo();
        bookInfoArrayList.get(1).printInfo();
        bookInfoArrayList.get(2).printInfo();
    }
}