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

public class LibraryControllerTest {
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
        LibraryController libraryController = new LibraryController(library);

        libraryController.issueBook(new User());

        Mockito.verify(library, times(1)).removeBook(input, new User());
    }

    @Test
    public void shouldDisplaySuccessMessageForSuccessfulCheckout() {
        String input = "Harry Potter";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Library library = new Library();
        LibraryController libraryController = new LibraryController(library);

        libraryController.issueBook(new User());

        assertEquals("Enter the name of book to be issued\n" +
                "Thank you! Enjoy the book\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldDisplayFailureMessageForUnsuccessfulCheckoutAttempt() {
        String input = "Harry";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Library library = new Library();
        LibraryController libraryController = new LibraryController(library);

        libraryController.issueBook(new User());

        assertEquals("Enter the name of book to be issued\n" +
                "That book is not available\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldAcceptValidBookNameFromUserAndAddTheBook() {
        String input = "Harry Potter";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Library library = mock(Library.class);
        LibraryController libraryController = new LibraryController(library);

        libraryController.returnBook(new User());

        Mockito.verify(library, times(1)).addBook(input, new User());
    }

    @Test
    public void shouldDisplaySuccessMessageForSuccessfulReturn() {
        String input = "Harry Potter";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Library library = mock(Library.class);
        when(library.addBook("Harry Potter", new User())).thenReturn(true);
        LibraryController libraryController = new LibraryController(library);

        libraryController.returnBook(new User());

        assertEquals("Enter the name of book to return\n" +
                "Thank you for returning the book.\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldDisplayFailureMessageForUnsuccessfulReturnAttempt() {
        String input = "Harry";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Library library = mock(Library.class);
        when(library.addBook("Harry", new User())).thenReturn(false);
        LibraryController libraryController = new LibraryController(library);

        libraryController.returnBook(new User());

        assertEquals("Enter the name of book to return\n" +
                "That is not a valid book to return.\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldAcceptValidMovieNameFromUserAndRemoveTheBook() {
        String input = "Titanic";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Library library = mock(Library.class);
        LibraryController libraryController = new LibraryController(library);

        libraryController.issueMovie();

        Mockito.verify(library, times(1)).removeMovie(input);
    }

    @Test
    public void shouldDisplaySuccessMessageForSuccessfulCheckoutofMovie() {
        String input = "Titanic";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Library library = new Library();
        LibraryController libraryController = new LibraryController(library);

        libraryController.issueMovie();

        assertEquals("Enter the name of movie to be issued\n" +
                "Thank you! Enjoy the movie\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldDisplayFailMessageForUnsuccessfulCheckoutofMovie() {
        String input = "Godzilla";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Library library = new Library();
        LibraryController libraryController = new LibraryController(library);

        libraryController.issueMovie();

        assertEquals("Enter the name of movie to be issued\n" +
                "That movie is not available\n", byteArrayOutputStream.toString());
    }
}
