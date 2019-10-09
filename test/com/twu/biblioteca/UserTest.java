package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import javax.jnlp.FileContents;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.*;

public class UserTest {
    AuthenticationService authenticationService;
    @Before
    public void setUp() {
        authenticationService = new AuthenticationService();
    }
    @Test
    public void successfulLoginWhenIntroducingCorrectCredentials() throws Exception {
        // Given that this current user exists
        String username = "111-1111";
        String password = "1234";

        // When authenticating
        authenticationService.login(username, password);

        // Then the current user must be valid
        assertEquals("111-1111", authenticationService.currentUser.getLibraryNumber());
        assertEquals("1234", authenticationService.currentUser.getPassword());
    }

    @Test
    public void displayRightMessageWhenLogInSuccessfully() throws Exception {
        // Given that this current user exists
        String username = "111-1111";
        String password = "1234";

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        StringWriter expectedStringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(expectedStringWriter);

        // When authenticating
        authenticationService.login(username, password);

        printWriter.println("LogIn successful!");
        String expected = expectedStringWriter.toString();
        assertEquals(expected,outContent.toString());
    }

    @Test
    public void unsuccessfulLoginWhenIntroducingWrongPassword() throws Exception {
        // Given that this current user exists
        String username = "111-1111";
        String password = "234";

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        StringWriter expectedStringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(expectedStringWriter);

        // When authenticating
        authenticationService.login(username, password);

        printWriter.println("LogIn not successful. Wrong password.");
        String expected = expectedStringWriter.toString();
        assertEquals(expected,outContent.toString());
    }

    @Test
    public void unsuccessfulLoginWhenIntroducingUserThatDoesntExist() throws Exception {
        // Given that this current user exists
        String username = "000-0000";
        String password = "234";

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        StringWriter expectedStringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(expectedStringWriter);

        // When authenticating
        authenticationService.login(username, password);

        printWriter.println("LogIn not successful. User not found.");
        String expected = expectedStringWriter.toString();
        assertEquals(expected,outContent.toString());
    }

    @Test
    public void displayUserProfileInformationSuccessfullyWhenAsked() {
        User user = authenticationService.getUser("111-1111");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        StringWriter expectedStringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(expectedStringWriter);

        printWriter.println("Elena's profile:");
        printWriter.println("Name: Elena");
        printWriter.println("Email: elena.izquierdo@email.com");
        printWriter.println("Phone Number: 612345678");
        printWriter.println("\n");
        String expected = expectedStringWriter.toString();

        user.displayProfileInformation();

        assertEquals(expected, outContent.toString());
    }

    @Test
    public void shouldChangeCurrentUserAttributeWhenLogInWithAnotherUser() {
        authenticationService.login("111-1111","1234");
        Boolean b = authenticationService.login("222-2222","1234");
        assertTrue(b);
        assertEquals("222-2222",authenticationService.currentUser.getLibraryNumber());
    }
}
