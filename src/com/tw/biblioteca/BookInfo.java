//has information about the book, and displays it
package com.tw.biblioteca;

public class BookInfo {
    private String name;
    private String author;
    private String yearOfPublication;

    public BookInfo(String name, String author, String yearOfPublication) {
        this.name = name;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    public void printInfo() {
        System.out.println(name + "\t" + author + "\t" + yearOfPublication);
    }
}