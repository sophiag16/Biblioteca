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
                "3. Checkout Book\n" +
                "4. Return Book\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldReturnMenuOptionChosenforOption1() {
        Menu menu = new Menu();
        String input = "1";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        int choice = menu.chosenValidOption();

        assertEquals(1, choice);
    }

    @Test
    public void shouldReturnInvalidOptionMessage() {
        Menu menu = new Menu();
        String input = "w";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        int choice = menu.chosenOption();

        assertEquals(0, choice);
    }

    @Test
    public void shouldReturnMenuOptionChosenforOption2() {
        Menu menu = new Menu();
        String input = "2";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        int choice = menu.chosenValidOption();

        assertEquals(2, choice);
    }

    @Test
    public void shouldReturnMenuOptionChosenforOption3() {
        Menu menu = new Menu();
        String input = "3";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        int choice = menu.chosenValidOption();

        assertEquals(3, choice);
    }

    @Test
    public void shouldReturnMenuOptionChosenforOption4() {
        Menu menu = new Menu();
        String input = "4";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        int choice = menu.chosenValidOption();

        assertEquals(4, choice);
    }

    @Test
    public void shouldReturnFalseForInvalidNumericOption() {
        Menu menu = new Menu();

        assertEquals(false, menu.isChoiceValid(0));
    }

    @Test
    public void shouldReturnInvalidOptionMessageForInvalidNumericOption() {
        Menu menu = new Menu();
        menu.isChoiceValid(0);

        assertEquals("Invalid option\n", byteArrayOutputStream.toString());
    }
}
