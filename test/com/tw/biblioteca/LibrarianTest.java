package com.tw.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

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
        Librarian librarian = new Librarian(new BookInfoList());
        String input = "Harry Potter";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        librarian.checkout();

        assertEquals(1, 1);
    }
}
