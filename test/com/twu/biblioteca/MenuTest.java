package com.twu.biblioteca;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class MenuTest {
    private Menu menu = new Menu();

    @Test
    public void illegalOptionMenuMessageWhenTryingAnInvalidOptionMenu(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        StringWriter expectedStringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(expectedStringWriter);
        printWriter.println("Choose a menu option(1, 2 or 3)");
        printWriter.println("1. List of books");
        printWriter.println("2. Return book");
        printWriter.println("3. Quit application");
        printWriter.println("Please select a valid option!");
        String expected = expectedStringWriter.toString();
        ByteArrayInputStream in = new ByteArrayInputStream("40".getBytes());
        System.setIn(in);
        menu.displayAndChoseOption();

        assertEquals(expected,outContent.toString());
        System.setIn(System.in);
    }
    @Test
    public void shouldReturnCharlWhenSelectingOption1InMenu(){
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        char res = menu.displayAndChoseOption();

        assertEquals('l',res);
        System.setIn(System.in);
    }
    @Test
    public void shouldReturnCharrWhenSelectingOption2InMenu(){
        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);
        char res = menu.displayAndChoseOption();

        assertEquals('r',res);
        System.setIn(System.in);
    }
    @Test
    public void shouldReturnCharqWhenSelectingOption3InMenu(){
        ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
        System.setIn(in);
        char res = menu.displayAndChoseOption();

        assertEquals('q',res);
        System.setIn(System.in);
    }
}
