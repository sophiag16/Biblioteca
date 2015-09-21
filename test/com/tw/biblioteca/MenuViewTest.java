package com.tw.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MenuViewTest {
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
    public void shouldDisplayMenu() {
        ArrayList<String> menuOptions = new ArrayList<String>();
        menuOptions.add("1. Some Option");
        MenuView menuView = new MenuView(menuOptions, new Display(new PrintStream(System.out)));
        String input = "1";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        menuView.readInput();

        assertEquals("1. Some Option\n", byteArrayOutputStream.toString());
    }

    public void shouldReturnMenuOptionChosen() {
        ArrayList<String> menuOptions = new ArrayList<String>();
        menuOptions.add("1. Some Option");
        MenuView menuView = new MenuView(menuOptions, new Display(new PrintStream(System.out)));
        String input = "1";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        assertEquals(input, menuView.readInput());
    }
}
