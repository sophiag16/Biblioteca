package com.tw.biblioteca;

public class Librarian {
    private BookInfoList bookInfoList = new BookInfoList();

    public Librarian(BookInfoList bookInfoList) {
        this.bookInfoList = bookInfoList;
    }

    public void checkout() {
        System.out.println("Enter the name of book to checkout");

    }
}
