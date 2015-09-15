package com.tw.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MovieTest {
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
    public void shouldDisplayInformationAboutMovie() {
        Movie movie = new Movie("Titanic", "James Cameron", "1997", "8");

        movie.printInfo();

        assertEquals("Titanic\tJames Cameron\t1997\t8\n", byteArrayOutputStream.toString());
    }
}
