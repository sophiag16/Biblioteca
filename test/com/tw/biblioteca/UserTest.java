package com.tw.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void shouldEquateToItself() {
        User user = new User("444-5555");

        assertEquals(true, user.equals(user));
    }

    @Test
    public void shouldEquateToAnotherUserWithSameLibraryNumber() {
        User user1 = new User("444-5555");
        User user2 = new User("444-5555");

        assertEquals(true, user1.equals(user2));
    }
}
