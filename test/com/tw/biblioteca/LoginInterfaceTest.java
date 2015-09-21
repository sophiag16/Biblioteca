package com.tw.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class LoginInterfaceTest {
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
    public void shouldAcceptLibraryNumberFromUser() {
        String input = "111-1111";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        LoginInterface loginInterface = new LoginInterface(new Scanner(inContent), new Display(new PrintStream(System.out)));

        assertEquals(input.toString(), loginInterface.libraryNumber().toString());
    }

    @Test
    public void shouldAcceptPasswordFromUser() {
        String input = "abcxyz";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        LoginInterface loginInterface = new LoginInterface(new Scanner(inContent), new Display(new PrintStream(System.out)));

        assertEquals(input.toString(), loginInterface.password().toString());
    }
}
