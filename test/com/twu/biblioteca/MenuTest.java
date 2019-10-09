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
        printWriter.println("Choose a menu option(1, 2, 3, 4, 5 or 6)");
        printWriter.println("1. List of books");
        printWriter.println("2. Return book");
        printWriter.println("3. List of movies");
        printWriter.println("4. List of all books including checkout users information");
        printWriter.println("5. View profile");
        printWriter.println("6. Quit application");
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
    public void shouldReturnCharqWhenSelectingOption6InMenu(){
        ByteArrayInputStream in = new ByteArrayInputStream("6".getBytes());
        System.setIn(in);
        char res = menu.displayAndChoseOption();

        assertEquals('q',res);
        System.setIn(System.in);
    }
    @Test
    public void shouldReturnCharmWhenSelectingOption3InMenu(){
        ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
        System.setIn(in);
        char res = menu.displayAndChoseOption();

        assertEquals('m',res);
        System.setIn(System.in);
    }

    @Test
    public void shouldReturnCharbWhenSelectingOption4InMenu(){
        ByteArrayInputStream in = new ByteArrayInputStream("4".getBytes());
        System.setIn(in);
        char res = menu.displayAndChoseOption();

        assertEquals('b',res);
        System.setIn(System.in);
    }

    @Test
    public void shouldReturnCharpWhenSelectingOption5InMenu(){
        ByteArrayInputStream in = new ByteArrayInputStream("5".getBytes());
        System.setIn(in);
        char res = menu.displayAndChoseOption();

        assertEquals('p',res);
        System.setIn(System.in);
    }
}
