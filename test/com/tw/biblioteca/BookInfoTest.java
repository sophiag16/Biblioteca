package com.tw.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

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
}
