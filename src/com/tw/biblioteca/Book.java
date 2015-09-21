//has information about the book, and displays it
package com.tw.biblioteca;

public class Book {
    private String name;
    private String author;
    private String yearOfPublication;

    public Book(String name, String author, String yearOfPublication) {
        this.name = name;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    public void printInfo() {
        System.out.println(String.format("%-34s %-34s %-34s", name, author, yearOfPublication));
    }

    @Override
    public boolean equals(Object that) {
        if (!(that instanceof Book)) {
            return false;
        }
        if(this == that) {
            return true;
        }
        Book thatLine = (Book) that;
        if(this.name.equals(thatLine.name)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}