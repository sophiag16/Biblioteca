package com.tw.biblioteca;

import com.sun.deploy.util.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MenuFactoryTest {
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
    public void shouldDisplayMenuOptionsForNonAdminUserAndGuest() {
        MenuFactory menuFactory = new MenuFactory(new User());
        String input = "1";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        assertEquals("1. List Books\n" +
                "2. Quit\n" +
                "3. Checkout Book\n" +
                "4. Return Book\n" +
                "5. List Movies\n" +
                "6. Checkout Movie\n" +
                "7. Login", StringUtils.join(menuFactory.createMenu(), "\n"));
    }

    @Test
    public void shouldDisplayMenuOptionsForAdmin() {
        MenuFactory menuFactory = new MenuFactory(new User("000-0000", "secret", "admin", "", "", "", new Display(new PrintStream(System.out))));
        String input = "1";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        assertEquals("1. List Books\n" +
                "2. Quit\n" +
                "3. Checkout Book\n" +
                "4. Return Book\n" +
                "5. List Movies\n" +
                "6. Checkout Movie\n" +
                "7. Logout\n" +
                "8. Show Book Details", StringUtils.join(menuFactory.createMenu(), "\n"));
    }

    @Test
    public void shouldDisplayMenuOptionsForLoggedInUser() {
        MenuFactory menuFactory = new MenuFactory(new User("000-0000", "secret", "user", "", "", "", new Display(new PrintStream(System.out))));
        String input = "1";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        assertEquals("1. List Books\n" +
                "2. Quit\n" +
                "3. Checkout Book\n" +
                "4. Return Book\n" +
                "5. List Movies\n" +
                "6. Checkout Movie\n" +
                "7. Logout\n" +
                "8. Show User Details", StringUtils.join(menuFactory.createMenu(), "\n"));
    }
}
