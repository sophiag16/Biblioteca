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
        System.setOut(null);
    }

    @Test
    public void shouldDisplayListOfBooks() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
        assertEquals("Harry Potter, To Kill A Mockingbird, A History Of Time", byteArrayOutputStream.toString().split("\n")[1]);
        System.setOut(null);
    }
}
