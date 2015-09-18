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

        assertEquals("Name\tAuthor\tYear of Publishing\n" +
                "Harry Potter\tJ K Rowling\t2001\n" +
                "To Kill A Mockingbird\tHarper Lee\t1970\n" +
                "A Brief History Of Time\tStephen Hawking\t1988\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldNotDisplayCheckedOutBooks() {
        Library library = new Library();

        library.removeBook("Harry Potter", new User());
        library.printBooks();

        assertEquals("Name\tAuthor\tYear of Publishing\n" +
                "To Kill A Mockingbird\tHarper Lee\t1970\n" +
                "A Brief History Of Time\tStephen Hawking\t1988\n", byteArrayOutputStream.toString());
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

        assertEquals("Name\tAuthor\tYear of Publishing\n" +
                "To Kill A Mockingbird\tHarper Lee\t1970\n" +
                "A Brief History Of Time\tStephen Hawking\t1988\n" +
                "Harry Potter\tJ K Rowling\t2001\n", byteArrayOutputStream.toString());
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

        assertEquals("Name\tYear\tDirector\tRating\n" +
                "Titanic\tJames Cameron\t1997\t8\n" +
                "Pursuit Of Happyness\tGabriele Muccino\t2006\t8\n" +
                "Inception\tChristopher Nolan\t2010\t8\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldNotDisplayCheckedOutMovies() {
        Library library = new Library();

        library.removeMovie("Titanic");
        library.printMovies();

        assertEquals("Name\tYear\tDirector\tRating\n" +
                "Pursuit Of Happyness\tGabriele Muccino\t2006\t8\n" +
                "Inception\tChristopher Nolan\t2010\t8\n", byteArrayOutputStream.toString());
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

        assertEquals("Library No.\tName\tAuthor\tYear of Publishing\n" +
                    "111-1111\tHarry Potter\tJ K Rowling\t2001\n", byteArrayOutputStream.toString());
    }
}
