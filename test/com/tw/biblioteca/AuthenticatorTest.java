package com.tw.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class AuthenticatorTest {

    @Test
    public void shouldAuthenticateAUserWithValidLibraryNumber() {
        String input = "111-1111";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Authenticator authenticator = new Authenticator();

        assertEquals(true, authenticator.isValid(new LoginInterface(new Scanner(System.in)).libraryNumber()));
    }

    @Test
    public void shouldFailAuthenticatingAUserWithInvalidLibraryNumber() {
        String input = "111-8755";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Authenticator authenticator = new Authenticator();

        assertEquals(false, authenticator.isValid(new LoginInterface(new Scanner(System.in)).libraryNumber()));
    }
}
