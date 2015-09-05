package com.tw.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BookInfoListTest {
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
    public void ShouldDisplayListOfBookInformation() {
        ArrayList<BookInfo> bookInfoArrayList = new ArrayList<BookInfo>();
        bookInfoArrayList.add(new BookInfo("Harry Potter", "J K Rowling", "2001"));
        bookInfoArrayList.add(new BookInfo("To Kill A Mockingbird", "Harper Lee", "1970"));
        bookInfoArrayList.add(new BookInfo("A Brief History Of Time", "Stephen Hawking", "1988"));
        BookInfoList bookInfoList = new BookInfoList(bookInfoArrayList);

        bookInfoList.printList();

        assertEquals("Name\tAuthor\tYear of Publishing\n" +
                "Harry Potter\tJ K Rowling\t2001\n" +
                "To Kill A Mockingbird\tHarper Lee\t1970\n" +
                "A Brief History Of Time\tStephen Hawking\t1988\n", byteArrayOutputStream.toString());
    }
}
