package com.tw.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MenuTest {
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
    public void shouldDisplayMenuOptions() {
        Menu menu = new Menu();
        String input = "1";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        int choice = menu.chosenOption();

        assertEquals("1. List Books\n" +
                      "2. Quit\n" +
                        "3. Checkout Book\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldReturnMenuOptionChosen() {
        Menu menu = new Menu();
        String input = "1";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        int choice = menu.chosenOption();

        assertEquals(1, choice);
    }
}
