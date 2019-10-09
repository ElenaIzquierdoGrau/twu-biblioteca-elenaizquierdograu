package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.*;

public class UserTest {
    AuthenticationService authenticationService = new AuthenticationService();
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

        printWriter.println("LogIn successful. Welcome to Biblioteca!");
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
}
