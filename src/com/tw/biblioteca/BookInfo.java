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

    @Override
    public boolean equals(Object that) {
        if (!(that instanceof BookInfo)) {
            return false;
        }
        if(this == that) {
            return true;
        }
        BookInfo thatLine = (BookInfo) that;
        if(this.name.equals(thatLine.name)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (yearOfPublication != null ? yearOfPublication.hashCode() : 0);
        return result;
    }
}