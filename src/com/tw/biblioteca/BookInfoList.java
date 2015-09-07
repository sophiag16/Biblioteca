//has a list of book-information and displays it
package com.tw.biblioteca;

import java.util.ArrayList;

public class BookInfoList {
    ArrayList<BookInfo> bookInfoArrayList = new ArrayList<BookInfo>();

    public BookInfoList() {
        bookInfoArrayList.add(new BookInfo("Harry Potter", "J K Rowling", "2001"));
        bookInfoArrayList.add(new BookInfo("To Kill A Mockingbird", "Harper Lee", "1970"));
        bookInfoArrayList.add(new BookInfo("A Brief History Of Time", "Stephen Hawking", "1988"));
    }

    public void printList() {
        System.out.print("Name\tAuthor\tYear of Publishing\n");
        bookInfoArrayList.get(0).printInfo();
        bookInfoArrayList.get(1).printInfo();
        bookInfoArrayList.get(2).printInfo();
    }
}