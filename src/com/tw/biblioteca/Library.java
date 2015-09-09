//has a list of book-information and displays it
package com.tw.biblioteca;

import java.util.ArrayList;

public class Library {
    ArrayList<Book> bookArrayList = new ArrayList<Book>();

    public Library() {
        bookArrayList.add(new Book("Harry Potter", "J K Rowling", "2001"));
        bookArrayList.add(new Book("To Kill A Mockingbird", "Harper Lee", "1970"));
        bookArrayList.add(new Book("A Brief History Of Time", "Stephen Hawking", "1988"));
    }

    public void printList() {
        System.out.print("Name\tAuthor\tYear of Publishing\n");
        for(int i = 0; i < bookArrayList.size(); i++)
            bookArrayList.get(i).printInfo();
    }

    public boolean remove(String bookName) {
        Book book = new Book(bookName, null, null);
        if(bookArrayList.contains(book)) {
            bookArrayList.remove(book);
            return true;
        }
        else {
            return false;
        }
    }
}