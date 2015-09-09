//has a set of book and handles it
package com.tw.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> availableBookArrayList = new ArrayList<Book>();
    private ArrayList<Book> issuedBookArrayList = new ArrayList<Book>();

    public Library() {
        availableBookArrayList.add(new Book("Harry Potter", "J K Rowling", "2001"));
        availableBookArrayList.add(new Book("To Kill A Mockingbird", "Harper Lee", "1970"));
        availableBookArrayList.add(new Book("A Brief History Of Time", "Stephen Hawking", "1988"));
    }

    public void printList() {
        System.out.print("Name\tAuthor\tYear of Publishing\n");
        for(int i = 0; i < availableBookArrayList.size(); i++)
            availableBookArrayList.get(i).printInfo();
    }

    public boolean removeBook(String bookName) {
        Book book = new Book(bookName, null, null);
        if(availableBookArrayList.contains(book)) {
            issuedBookArrayList.add(availableBookArrayList.remove(availableBookArrayList.indexOf(book)));
            return true;
        }
        else {
            return false;
        }
    }

    public boolean addBook(String bookName) {
        Book book = new Book(bookName, null, null);
        if(issuedBookArrayList.contains(book)) {
            availableBookArrayList.add(issuedBookArrayList.remove(issuedBookArrayList.indexOf(book)));
            return true;
        }
        else {
            return false;
        }
    }
}