package com.tw.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @Before
    public void setStreams() {
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @After
    public void CleanUpStreams() {
        System.setOut(System.out);
    }

    @Test
    public void shouldDisplayListOfBookInformation() {
        Library library = new Library();

        library.printBooks();

        assertEquals(String.format("%-34s %-34s %-34s\n", "Name", "Author", "Year of Publishing") +
                String.format("%-34s %-34s %-34s\n", "Harry Potter", "J K Rowling", "2001") +
                String.format("%-34s %-34s %-34s\n", "To Kill A Mockingbird", "Harper Lee", "1970") +
                String.format("%-34s %-34s %-34s\n\n", "A Brief History Of Time", "Stephen Hawking", "1988"), byteArrayOutputStream.toString());
    }

    @Test
    public void shouldNotDisplayCheckedOutBooks() {
        Library library = new Library();

        library.removeBook("Harry Potter", new User());
        library.printBooks();

        assertEquals(String.format("%-34s %-34s %-34s\n", "Name", "Author", "Year of Publishing") +
                String.format("%-34s %-34s %-34s\n", "To Kill A Mockingbird", "Harper Lee", "1970") +
                String.format("%-34s %-34s %-34s\n\n", "A Brief History Of Time", "Stephen Hawking", "1988"), byteArrayOutputStream.toString());
    }

    @Test
    public void shouldReturnTrueIfSuccessfullyIssued() {
        Library library = new Library();

        assertEquals(true, library.removeBook("Harry Potter", new User()));
    }

    @Test
    public void shouldReturnFalseIfFailedToIssue() {
        Library library = new Library();

        assertEquals(false, library.removeBook("Harry", new User()));
    }

    @Test
    public void shouldAgainDisplayReturnedBooks() {
        Library library = new Library();

        library.removeBook("Harry Potter", new User());
        library.addBook("Harry Potter", new User());
        library.printBooks();

        assertEquals(String.format("%-34s %-34s %-34s\n", "Name", "Author", "Year of Publishing") +
                String.format("%-34s %-34s %-34s\n", "To Kill A Mockingbird", "Harper Lee", "1970") +
                String.format("%-34s %-34s %-34s\n", "A Brief History Of Time", "Stephen Hawking", "1988") +
                String.format("%-34s %-34s %-34s\n\n", "Harry Potter", "J K Rowling", "2001"), byteArrayOutputStream.toString());
    }

    @Test
    public void shouldReturnTrueIfSuccessfullyReturned() {
        Library library = new Library();

        library.removeBook("Harry Potter", new User());

        assertEquals(true, library.addBook("Harry Potter", new User()));
    }

    @Test
    public void shouldReturnFalseIfFailedToReturn() {
        Library library = new Library();

        assertEquals(false, library.addBook("Harry", new User()));
    }

    @Test
    public void shouldDisplayListOfMovies() {
        Library library = new Library();

        library.printMovies();

        assertEquals(String.format("%-34s %-34s %-34s %-34s\n", "Name", "Year", "Director", "Rating") +
                String.format("%-34s %-34s %-34s %-34s\n", "Titanic", "James Cameron", "1997", "8") +
                String.format("%-34s %-34s %-34s %-34s\n", "Pursuit Of Happyness", "Gabriele Muccino", "2006", "8") +
                String.format("%-34s %-34s %-34s %-34s\n\n", "Inception", "Christopher Nolan", "2010", "8"), byteArrayOutputStream.toString());
    }

    @Test
    public void shouldNotDisplayCheckedOutMovies() {
        Library library = new Library();

        library.removeMovie("Titanic");
        library.printMovies();

        assertEquals(String.format("%-34s %-34s %-34s %-34s\n", "Name", "Year", "Director", "Rating") +
                String.format("%-34s %-34s %-34s %-34s\n", "Pursuit Of Happyness", "Gabriele Muccino", "2006", "8") +
                String.format("%-34s %-34s %-34s %-34s\n\n", "Inception", "Christopher Nolan", "2010", "8"), byteArrayOutputStream.toString());
    }

    @Test
    public void shouldReturnFalseIfFailedToCheckoutMovie() {
        Library library = new Library();

        assertEquals(false, library.removeMovie("Godzilla"));
    }

    @Test
    public void shouldReturnTrueIfSuccessfullyCheckoutMovie() {
        Library library = new Library();

        assertEquals(true, library.removeMovie("Titanic"));
    }

    @Test
    public void shouldReturnFalseIfDifferentUserTriesToReturn() {
        Library library = new Library();
        library.removeBook("Harry Potter", new User());

        assertEquals(false, library.addBook("Harry Potter", new User("345-1234", "", "", "", "", "")));
    }

    @Test
    public void shouldPrintBookAndUserInfo() {
        Library library = new Library();
        library.removeBook("Harry Potter", new User("111-1111", "abcxyz", "user", "", "", ""));
        library.printBookInfo();

        assertEquals(String.format("%-34s %-34s %-34s %-34s\n", "Library No.", "Name", "Author", "Year of Publishing") +
                    String.format("%-34s %-34s %-34s %-34s\n\n", "111-1111", "Harry Potter", "J K Rowling", "2001"), byteArrayOutputStream.toString());
    }
}
