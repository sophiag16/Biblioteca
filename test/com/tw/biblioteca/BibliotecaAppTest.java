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
        assertEquals("Welcome to Biblioteca", byteArrayOutputStream.toString());
        System.setOut(null);
    }
}
