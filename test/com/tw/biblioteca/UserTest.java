package com.tw.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UserTest {

    @Test
    public void shouldEquateToItself() {
        User user = new User("444-5555", "");

        assertEquals(true, user.equals(user));
    }

    @Test
    public void shouldEquateToAnotherUserWithSameLibraryNumber() {
        User user1 = new User("444-5555", "");
        User user2 = new User("444-5555", "");

        assertEquals(true, user1.equals(user2));
    }

    @Test
    public void shouldNotEquateToAnotherUserDifferentLibraryNumber() {
        User user1 = new User("444-5555", "");
        User user2 = new User("222-9876", "");

        assertNotEquals(true, user1.equals(user2));
    }

    @Test
    public void shouldNotEquateToNull() {
        User user1 = new User("444-5555", "");

        assertNotEquals(true, user1.equals(null));
    }

    @Test
    public void shouldReturnTrueIfPasswordsMatch() {
        User user = new User("111-1111", "abcxyz");

        assertEquals(true, user.checkPassword("abcxyz"));
    }

    @Test
    public void shouldReturnFalseIfPasswordsDontMatch() {
        User user = new User("111-1111", "lj66409h");

        assertEquals(false, user.checkPassword("abcxyz"));
    }
}
