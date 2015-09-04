//has a list of book-information and displays it
package com.tw.biblioteca;

public class BookInfoList {
    BookInfo bookInfo1;
    BookInfo bookInfo2;
    BookInfo bookInfo3;

    public BookInfoList() {
        bookInfo1 = new BookInfo("Harry Potter", "J K Rowling", "2001");
        bookInfo2 = new BookInfo("To Kill A Mockingbird", "Harper Lee", "1970");
        bookInfo3 = new BookInfo("A Brief History Of Time", "Stephen Hawking", "1988");
    }

    public void printList() {
        System.out.print("Name\tAuthor\tYear of Publishing\n");
        bookInfo1.printInfo();
        bookInfo2.printInfo();
        bookInfo3.printInfo();
    }
}
