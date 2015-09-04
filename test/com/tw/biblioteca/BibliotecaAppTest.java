package com.tw.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    @Test
    public void shouldDisplayWelcomeMessage() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
        assertEquals("Welcome to Biblioteca", byteArrayOutputStream.toString().split("\n")[0]);
        System.setOut(System.out);
    }

    @Test
    public void shouldDisplayListOfBooks() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
        assertEquals("Name\tAuthor\tYear of Publishing\n" +
                "Harry Potter\tJ K Rowling\t2001\n" +
                "To Kill A Mockingbird\tHarper Lee\t1970\n" +
                "A Brief History Of Time\tStephen Hawking\t1988", byteArrayOutputStream.toString().split("\n")[1] + "\n" +
                                                                    byteArrayOutputStream.toString().split("\n")[2] + "\n" +
                                                                    byteArrayOutputStream.toString().split("\n")[3] + "\n" +
                                                                    byteArrayOutputStream.toString().split("\n")[4]);
        System.setOut(System.out);
    }
}
