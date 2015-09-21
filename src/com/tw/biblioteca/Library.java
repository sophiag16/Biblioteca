//has a set of book and movies and handles them
package com.tw.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private ArrayList<Book> availableBookArrayList = new ArrayList<Book>();
    private HashMap<Book, User> issuedBookHashMap = new HashMap<Book, User>();
    private ArrayList<Book> issuedBookArrayList = new ArrayList<Book>();
    private ArrayList<Movie> moviesArrayList = new ArrayList<Movie>();
    private Display display;

    public Library(Display display) {
        this.display = display;
        availableBookArrayList.add(new Book("Harry Potter", "J K Rowling", "2001"));
        availableBookArrayList.add(new Book("To Kill A Mockingbird", "Harper Lee", "1970"));
        availableBookArrayList.add(new Book("A Brief History Of Time", "Stephen Hawking", "1988"));

        moviesArrayList.add(new Movie("Titanic", "James Cameron", "1997", "8", new Display(new PrintStream(System.out))));
        moviesArrayList.add(new Movie("Pursuit Of Happyness", "Gabriele Muccino", "2006", "8", new Display(new PrintStream(System.out))));
        moviesArrayList.add(new Movie("Inception", "Christopher Nolan", "2010", "8", new Display(new PrintStream(System.out))));
    }

    public void printBooks() {
        display.printString(String.format("%-34s %-34s %-34s\n", "Name", "Author", "Year of Publishing"));
        for(int i = 0; i < availableBookArrayList.size(); i++)
            availableBookArrayList.get(i).printInfo();
        display.printString("\n");
    }

    public void printMovies() {
        display.printString(String.format("%-34s %-34s %-34s %-34s\n", "Name", "Year", "Director", "Rating"));
        for(int i = 0; i < moviesArrayList.size(); i++)
            moviesArrayList.get(i).printInfo();
        display.printString("\n");
    }

    public boolean removeBook(String bookName, User currentUser) {
        Book book = new Book(bookName, null, null);
        if(availableBookArrayList.contains(book)) {
            issuedBookHashMap.put(availableBookArrayList.get(availableBookArrayList.indexOf(book)), currentUser);
            issuedBookArrayList.add(availableBookArrayList.remove(availableBookArrayList.indexOf(book)));
            return true;
        }
        else {
            return false;
        }
    }

    public boolean addBook(String bookName, User currentUser) {
        Book book = new Book(bookName, null, null);
        if(issuedBookHashMap.containsKey(book) && currentUser.equals(issuedBookHashMap.get(book))) {
            availableBookArrayList.add(issuedBookArrayList.remove(issuedBookArrayList.indexOf(book)));
            issuedBookHashMap.remove(book);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean removeMovie(String movieName) {
        Movie movie = new Movie(movieName, null, null, null, new Display(new PrintStream(System.out)));
        if(moviesArrayList.contains(movie)) {
            moviesArrayList.remove(movie);
            return true;
        }
        return false;
    }

    public void printBookInfo() {
        display.printString(String.format("%-34s %-34s %-34s %-34s\n", "Library No.", "Name", "Author", "Year of Publishing"));
        for(int i = 0; i < issuedBookHashMap.size(); i++) {
            Book book = issuedBookArrayList.get(i);
            issuedBookHashMap.get(book).printLibraryNumber();
            book.printInfo();
        }
        display.printString("\n");
    }
}