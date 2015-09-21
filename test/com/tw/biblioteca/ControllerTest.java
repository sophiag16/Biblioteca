package com.tw.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

public class ControllerTest {
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Before
    public void setStreams() {
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @After
    public void CleanUpStreams() {
        System.setOut(System.out);
    }

    @Test
    public void shouldDisplayListOfBooksIfOptionOneIsChosen() {
        Controller controller = new Controller("1", new Library(), new Authenticator(), new User());

        controller.dispatch();

        assertEquals(String.format("%-34s %-34s %-34s\n", "Name", "Author", "Year of Publishing") +
                String.format("%-34s %-34s %-34s\n", "Harry Potter", "J K Rowling", "2001") +
                String.format("%-34s %-34s %-34s\n", "To Kill A Mockingbird", "Harper Lee", "1970") +
                String.format("%-34s %-34s %-34s\n", "A Brief History Of Time", "Stephen Hawking", "1988"), byteArrayOutputStream.toString());
    }

    @Test
    public void shouldExitIfOptionTwoIsChosen() {
        exit.expectSystemExit();
        Controller controller = new Controller("2", new Library(), new Authenticator(), new User());
        controller.dispatch();
    }

    @Test
    public void shouldCheckoutBookIfOptionThreeIsChosen() {
        String input = "Harry Potter";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Library library = mock(Library.class);
        Controller controller = new Controller("3", library, new Authenticator(), new User("", "", "user", "", "", ""));

        controller.dispatch();

        Mockito.verify(library, times(1)).removeBook(input, new User());
    }

    @Test
    public void shouldReturnBookIfOptionFourIsChosen() {
        String input = "Harry Potter";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Library library = mock(Library.class);
        Controller controller = new Controller("4", library, new Authenticator(), new User("", "", "user", "", "", ""));

        controller.dispatch();

        Mockito.verify(library, times(1)).addBook(input, new User());
    }

    @Test
    public void shouldDisplayInvalidMessageWhenInvalidOptionIsChosen() {
        String input = "1";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Controller controller = new Controller("0", new Library(), new Authenticator(), new User());
        controller.dispatch();

        assertEquals("Invalid option", byteArrayOutputStream.toString().split("\n")[0]);
    }

    @Test
    public void shouldCallPrintMoviesIfOptionFiveIsChosen() {
        Library library = mock(Library.class);
        Controller controller = new Controller("5", library, new Authenticator(), new User());

        controller.dispatch();

        Mockito.verify(library, times(1)).printMovies();
    }

    @Test
    public void shouldCallRemoveMovieIfOptionSixIsChosen() {
        String input = "Titanic";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Library library = mock(Library.class);
        Controller controller = new Controller("6", library, new Authenticator(), new User());

        controller.dispatch();

        Mockito.verify(library, times(1)).removeMovie(input);
    }

    @Test
    public void shouldCallValidatingMethodOfAuthenticatorIfOptionSevenIsChosen() {
        Authenticator authenticator = mock(Authenticator.class);
        String input = "444-5678\n" + "arfgdfg";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Controller controller = new Controller("7", new Library(), authenticator, new User());

        controller.dispatch();

        Mockito.verify(authenticator, times(1)).isValid("444-5678", "arfgdfg");
    }

    @Test
    public void shouldReturnUserIfLoginOptionIsChosen() {
        String input = "111-1111\n" + "abcxyz";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Controller controller = new Controller("7", new Library(), new Authenticator(), new User());

        assertEquals(true, new User("111-1111", "abcxyz", "user", "", "", "").equals(controller.dispatch()));
    }

    @Test
    public void shouldDisplayLoginRequiredMessageToGuestUserForBookIssue() {
        Controller controller = new Controller("3", new Library(), new Authenticator(), new User());

        controller.dispatch();

        assertEquals("You need to login for this\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldDisplayLoginRequiredMessageToGuestUserForBookReturn() {
        Controller controller = new Controller("4", new Library(), new Authenticator(), new User());

        controller.dispatch();

        assertEquals("You need to login for this\n", byteArrayOutputStream.toString());
    }



    @Test
    public void shouldReturnGuestUserIfLogoutOptionIsChosen() {
        Controller controller = new Controller("7", new Library(), new Authenticator(), new User("123-4325", "dgdfg", "user", "", "", ""));

        assertEquals(true, new User().equals(controller.dispatch()));
    }

    @Test
    public void shouldPrintBookInfoIfAdminChoosesOptionNine() {
        Library library = mock(Library.class);
        Controller controller = new Controller("8", library, new Authenticator(), new User("", "", "admin", "", "", ""));

        controller.dispatch();

        Mockito.verify(library, times(1)).printBookInfo();
    }

    @Test
    public void shouldPrintInvalidOptionIfNonAdminChoosesOptionNine() {
        Controller controller = new Controller("8", new Library(), new Authenticator(), new User());

        controller.dispatch();

        assertEquals("Invalid option", byteArrayOutputStream.toString().split("\n")[0]);
    }

    @Test
    public void shouldPrintUserInfoIfLoggedInUserChoosesOptionNine() {
        Controller controller = new Controller("8", new Library(), new Authenticator(), new User("111-1111", "lj66409h", "user", "Sophia", "sophia@gmail.com", "9874375476354"));

        controller.dispatch();

        assertEquals("Name: " + "Sophia" +
                "\nEmail: " + "sophia@gmail.com" +
                "\nPhone: " + "9874375476354\n", byteArrayOutputStream.toString());
    }
}
