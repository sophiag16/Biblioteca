package com.tw.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class LibrarianTest {
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
    public void shouldAcceptValidBookNameFromUserAndRemoveTheBook() {
        String input = "Harry Potter";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Library library = mock(Library.class);
        Librarian librarian = new Librarian(library);

        librarian.issueBook();

        Mockito.verify(library, times(1)).removeBook(input);
    }

    @Test
    public void shouldDisplaySuccessMessageForSuccessfulCheckout() {
        String input = "Harry Potter";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Library library = new Library();
        Librarian librarian = new Librarian(library);

        librarian.issueBook();

        assertEquals("Enter the name of book to issueBook\n" +
                "Thank you! Enjoy the book\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldDisplayFailureMessageForUnsuccessfulCheckoutAttempt() {
        String input = "Harry";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Library library = new Library();
        Librarian librarian = new Librarian(library);

        librarian.issueBook();

        assertEquals("Enter the name of book to issueBook\n" +
                "That book is not available\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldAcceptValidBookNameFromUserAndAddTheBook() {
        String input = "Harry Potter";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Library library = mock(Library.class);
        Librarian librarian = new Librarian(library);

        librarian.returnBook();

        Mockito.verify(library, times(1)).addBook(input);
    }

    @Test
    public void shouldDisplaySuccessMessageForSuccessfulReturn() {
        String input = "Harry Potter";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Library library = mock(Library.class);
        when(library.addBook("Harry Potter")).thenReturn(true);
        Librarian librarian = new Librarian(library);

        librarian.returnBook();

        assertEquals("Enter the name of book to issueBook\n" +
                "Thank you for returning the book.\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldDisplayFailureMessageForUnsuccessfulReturnAttempt() {
        String input = "Harry";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Library library = mock(Library.class);
        when(library.addBook("Harry")).thenReturn(false);
        Librarian librarian = new Librarian(library);

        librarian.returnBook();

        assertEquals("Enter the name of book to issueBook\n" +
                "That is not a valid book to return.\n", byteArrayOutputStream.toString());
    }
}
