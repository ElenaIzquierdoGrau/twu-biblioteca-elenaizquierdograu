package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.*;

public class BibliotecaTest {
    private BibliotecaApp bibliotecaApp;
    private Library l;

    @Before
    public void setUp() {
        bibliotecaApp = new BibliotecaApp();
        l = new Library();
    }


    @Test
    public void getWelcomeMessageSuccessfully() {
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", bibliotecaApp.getWelcomeMessage());
    }

   @Test
    public void printBooksSuccessfully() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        StringWriter expectedStringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(expectedStringWriter);
        printWriter.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        printWriter.println("Here you have the list of all the books in the library");
        printWriter.println("|      Title            |       Author      |   Year  |    User who has the book");
        printWriter.println("Lo que el viento se llevo | Elena Izquierdo | 1997 | None");
        printWriter.println("La sombra del viento | Elena Grau | 2017 | None");
        String expected = expectedStringWriter.toString();

        bibliotecaApp.printAllBooks();

        assertEquals(expected,outContent.toString());
    }

}
