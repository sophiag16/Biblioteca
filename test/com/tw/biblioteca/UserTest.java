package com.tw.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UserTest {
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
    public void shouldEquateToItself() {
        User user = new User("444-5555", "", "", "", "", "", new Display(new PrintStream(System.out)));

        assertEquals(true, user.equals(user));
    }

    @Test
    public void shouldEquateToAnotherUserWithSameLibraryNumber() {
        User user1 = new User("444-5555", "", "", "", "", "", new Display(new PrintStream(System.out)));
        User user2 = new User("444-5555", "", "", "", "", "", new Display(new PrintStream(System.out)));

        assertEquals(true, user1.equals(user2));
    }

    @Test
    public void shouldNotEquateToAnotherUserDifferentLibraryNumber() {
        User user1 = new User("444-5555", "", "", "", "", "", new Display(new PrintStream(System.out)));
        User user2 = new User("222-9876", "", "", "", "", "", new Display(new PrintStream(System.out)));

        assertNotEquals(true, user1.equals(user2));
    }

    @Test
    public void shouldNotEquateToNull() {
        User user1 = new User("444-5555", "", "", "", "", "", new Display(new PrintStream(System.out)));

        assertNotEquals(true, user1.equals(null));
    }

    @Test
    public void shouldReturnTrueIfPasswordsMatch() {
        User user = new User("111-1111", "abcxyz", "", "", "", "", new Display(new PrintStream(System.out)));

        assertEquals(true, user.checkPassword("abcxyz"));
    }

    @Test
    public void shouldReturnFalseIfPasswordsDontMatch() {
        User user = new User("111-1111", "lj66409h", "", "", "", "", new Display(new PrintStream(System.out)));

        assertEquals(false, user.checkPassword("abcxyz"));
    }

    @Test
    public void shouldReturnTheRole() {
        User user = new User("111-1111", "lj66409h", "someRole", "", "", "", new Display(new PrintStream(System.out)));

        assertEquals("someRole", user.role());
    }

    @Test
    public void shouldPrintLibraryNumber() {
        User user = new User("111-1111", "lj66409h", "someRole", "", "", "", new Display(new PrintStream(System.out)));
        user.printLibraryNumber();

        assertEquals(String.format("%-34s ", "111-1111"), byteArrayOutputStream.toString());
    }

    @Test
    public void shouldPrintUserInfo() {
        User user = new User("111-1111", "lj66409h", "someRole", "Sophia", "sophia@gmail.com", "9874375476354", new Display(new PrintStream(System.out)));
        user.printInfo();

        assertEquals("Name: " + "Sophia" +
                "\nEmail: " + "sophia@gmail.com" +
                "\nPhone: " + "9874375476354\n", byteArrayOutputStream.toString());
    }
}
