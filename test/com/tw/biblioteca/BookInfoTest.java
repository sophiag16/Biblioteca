package com.tw.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BookInfoTest {
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
        BookInfo bookInfo = new BookInfo("Harry Potter", "J K Rowling", "2001");

        bookInfo.printInfo();

        assertEquals("Harry Potter" + "\t" + "J K Rowling" + "\t" + "2001\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldBeEqualToItself() {
        BookInfo bookInfo = new BookInfo("james", "bond", "1980");

        assertEquals(bookInfo, bookInfo);
    }

    @Test
    public void shouldNotBeEqualToAString() {
        BookInfo bookInfo = new BookInfo("james", "bond", "1980");

        assertNotEquals(bookInfo, "someBook");
    }

    @Test
    public void shoulNotBeEqualToNull() {
        BookInfo bookInfo = new BookInfo("james", "bond", "1980");

        assertNotEquals(bookInfo, null);
    }

    @Test
    public void shoulNotBeEqualToAnotherBook() {
        BookInfo bookInfo1 = new BookInfo("james", "bond", "1980");
        BookInfo bookInfo2 = new BookInfo("james", "bond", "1980");

        assertEquals(bookInfo1, bookInfo2);
    }
}
