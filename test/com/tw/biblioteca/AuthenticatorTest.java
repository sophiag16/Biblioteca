package com.tw.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AuthenticatorTest {

    @Test
    public void shouldAuthenticateAUserWithValidLibraryNumberAndPassword() {
        Authenticator authenticator = new Authenticator();

        assertEquals(true, authenticator.isValid("111-1111", "abcxyz"));
    }

    @Test
    public void shouldFailAuthenticatingAUserWithInvalidLibraryNumber() {
        Authenticator authenticator = new Authenticator();

        assertEquals(false, authenticator.isValid("111-8755", "askldjf"));
    }

    @Test
    public void shouldFailAuthenticatingAUserWithInvalidPassword() {
        Authenticator authenticator = new Authenticator();

        assertEquals(false, authenticator.isValid("111-1111", "askldjf"));
    }
}
