package com.tw.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BookInfoTest {
    @Test
    public void shouldDisplayInformationAboutBooks() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        BookInfo bookInfo = new BookInfo("Harry Potter", "J K Rowling", "2001");
        bookInfo.printBookInfo();
        assertEquals("Harry Potter" + "\t" + "J K Rowling" + "\t" + "2001\n", byteArrayOutputStream.toString());
        System.setOut(System.out);
    }
}
