package com.tw.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AuthenticatorTest {

    @Test
    public void shouldAuthenticateAUserWithValidLibraryNumberAndPassword() {
        Authenticator authenticator = new Authenticator();

        assertEquals("user", authenticator.isValid("111-1111", "abcxyz").role());
    }

    @Test
    public void shouldFailAuthenticatingAUserWithInvalidLibraryNumber() {
        Authenticator authenticator = new Authenticator();

        assertEquals("guest", authenticator.isValid("111-8755", "askldjf").role());
    }

    @Test
    public void shouldFailAuthenticatingAUserWithInvalidPassword() {
        Authenticator authenticator = new Authenticator();

        assertEquals("guest", authenticator.isValid("111-1111", "askldjf").role());
    }

    @Test
    public void shouldAuthenticateLibrarian() {
        Authenticator authenticator = new Authenticator();

        assertEquals("admin", authenticator.isValid("000-0000", "secret").role());
    }
}
