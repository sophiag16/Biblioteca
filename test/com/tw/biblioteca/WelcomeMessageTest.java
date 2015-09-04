package com.tw.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class WelcomeMessageTest {

    @Test
    public void shouldPrintTheWelcomeMessage() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        WelcomeMessage welcomeMessage = new WelcomeMessage();
        welcomeMessage.display();
        assertEquals("Welcome to Biblioteca\n", byteArrayOutputStream.toString());
        System.setOut(System.out);
    }
}
