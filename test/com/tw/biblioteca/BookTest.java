package com.tw.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BookTest {
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
    public void shouldDisplayInformationAboutBooks() {
        Book book = new Book("Harry Potter", "J K Rowling", "2001");

        book.printInfo();

        assertEquals("Harry Potter" + "\t" + "J K Rowling" + "\t" + "2001\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldBeEqualToItself() {
        Book book = new Book("james", "bond", "1980");

        assertEquals(book, book);
    }

    @Test
    public void shouldNotBeEqualToAString() {
        Book book = new Book("james", "bond", "1980");

        assertNotEquals(book, "someBook");
    }

    @Test
    public void shoulNotBeEqualToNull() {
        Book book = new Book("james", "bond", "1980");

        assertNotEquals(book, null);
    }

    @Test
    public void shoulNotBeEqualToAnotherBook() {
        Book book1 = new Book("james", "bond", "1980");
        Book book2 = new Book("james", "bond", "1980");

        assertEquals(book1, book2);
    }

    @Test
    public void shouldCompareABookToItselfUsingHashcode() {
        Book book = new Book("james", "bond", "1980");
        assertEquals(book.hashCode(), book.hashCode());
    }

    @Test
    public void shouldCompareTwoEqualBooksUsingHashcode() {
        Book book1 = new Book("james", "bond", "1980");
        Book book2 = new Book("james", "bond", "1980");
        assertEquals(book1.hashCode(), book2.hashCode());
    }
}
