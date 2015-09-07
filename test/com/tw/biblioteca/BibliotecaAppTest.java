package com.tw.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Before
    public void setStreams() {
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @After
    public void CleanUpStreams() {
        System.setOut(System.out);
    }

    @Test
    public void shouldDisplayListOfBooks() {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String input = "1";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        bibliotecaApp.start();

        assertEquals("Welcome to Biblioteca\n" +
                "1. List Books\n" +
                "2. Quit\n" +
                "Name\tAuthor\tYear of Publishing\n" +
                "Harry Potter\tJ K Rowling\t2001\n" +
                "To Kill A Mockingbird\tHarper Lee\t1970\n" +
                "A Brief History Of Time\tStephen Hawking\t1988\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldExitWhenQuitIsChosen() {
        exit.expectSystemExit();
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        String input = "2";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        bibliotecaApp.start();
    }
}
