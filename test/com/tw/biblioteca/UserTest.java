package com.tw.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void shouldEquateToItself() {
        User user = new User();

        assertEquals(true, user.equals(user));
    }
}
