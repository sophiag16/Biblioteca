package com.tw.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
        Movie movie = new Movie("Titanic", "James Cameron", "1997", "8", new Display(new PrintStream(System.out)));

        movie.printInfo();

        assertEquals(String.format("%-34s %-34s %-34s %-34s\n", "Titanic", "James Cameron", "1997", "8"), byteArrayOutputStream.toString());
    }

    @Test
    public void shouldBeEqualToItself() {
        Movie movie = new Movie("Titanic", "James Cameron", "1997", "8", new Display(new PrintStream(System.out)));

        assertEquals(movie, movie);
    }

    @Test
    public void shoulBeEqualToAnotherSameMovie() {
        Movie movie1 = new Movie("Titanic", "James Cameron", "1997", "8", new Display(new PrintStream(System.out)));
        Movie movie2 = new Movie("Titanic", "James Cameron", "1997", "8", new Display(new PrintStream(System.out)));

        assertEquals(movie1, movie2);
    }

    @Test
    public void shouldNotBeEqualToAString() {
        Movie movie = new Movie("Titanic", "James Cameron", "1997", "8", new Display(new PrintStream(System.out)));

        assertNotEquals(movie, "someBook");
    }

    @Test
    public void shoulBeUnequalToAnotherMovieWithDifferentName() {
        Movie movie1 = new Movie("Titanic", "James Cameron", "1997", "8", new Display(new PrintStream(System.out)));
        Movie movie2 = new Movie("Inception", "Christopher Nolan", "2010", "8", new Display(new PrintStream(System.out)));

        assertNotEquals(movie1, movie2);
    }

    @Test
    public void shouldCompareAMovieToItselfUsingHashcode() {
        Movie movie = new Movie("Titanic", "James Cameron", "1997", "8", new Display(new PrintStream(System.out)));

        assertEquals(movie.hashCode(), movie.hashCode());
    }

    @Test
    public void shouldCompareTwoUnequalBooksUsingHashcode() {
        Movie movie1 = new Movie("Titanic", "James Cameron", "1997", "8", new Display(new PrintStream(System.out)));
        Movie movie2 = new Movie("Inception", "Christopher Nolan", "2010", "8", new Display(new PrintStream(System.out)));

        assertNotEquals(movie1.hashCode(), movie2.hashCode());
    }

    @Test
    public void sampleTest() {
        assertEquals(1,2);
    }
}
