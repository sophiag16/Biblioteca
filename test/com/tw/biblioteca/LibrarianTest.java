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
        BookInfoList bookInfoList = mock(BookInfoList.class);
        Librarian librarian = new Librarian(bookInfoList);

        librarian.checkout();

        Mockito.verify(bookInfoList, times(1)).remove(input);
    }

    @Test
    public void shouldDisplaySuccessMessage() {
        String input = "Harry Potter";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        BookInfoList bookInfoList = new BookInfoList();
        Librarian librarian = new Librarian(bookInfoList);

        librarian.checkout();

        assertEquals("Enter the name of book to checkout\n" +
                    "Thank you! Enjoy the book\n", byteArrayOutputStream.toString());
    }
}
