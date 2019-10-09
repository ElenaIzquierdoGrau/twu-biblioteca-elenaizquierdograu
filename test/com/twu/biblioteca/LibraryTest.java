package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.*;

public class LibraryTest {
    private Library l = new Library();
    @Test
    public void successfullyListAllBooksAvailable(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        StringWriter expectedStringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(expectedStringWriter);
        printWriter.println("Here you have the list of available books of the library");
        printWriter.println("|      Title            |       Author      |   Year  |");
        printWriter.println("Lo que el viento se llevo | Elena Izquierdo | 1997");
        printWriter.println("La sombra del viento | Elena Grau | 2017");
        String expected = expectedStringWriter.toString();

        l.listAvailableBooks();

        assertEquals(expected,outContent.toString());
    }

    @Test
    public void getBookInfoCorrectlyWhenAskedByTitle(){
        Book res = l.infoBook("Lo que el viento se llevo");

        assertEquals("Lo que el viento se llevo",res.title);
        assertEquals("Elena Izquierdo",res.author);
        assertEquals("1997",res.year.toString());
    }

    @Test
    public void successfulCheckOutBookWhenCheckoutABookAvailable(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        l.checkOutBook("Lo que el viento se llevo");

        StringWriter expectedStringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(expectedStringWriter);
        printWriter.println("Thank you! Enjoy the book");
        String expected = expectedStringWriter.toString();

        assertEquals(expected,outContent.toString());
    }

    @Test
    public void unsuccesfulCheckoutBookWhenWrongSpellingTitle(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        l.checkOutBook("Lo que el viento se levo");

        StringWriter expectedStringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(expectedStringWriter);
        printWriter.println("Sorry, that book is not available");
        String expected = expectedStringWriter.toString();

        assertEquals(expected,outContent.toString());
    }

    @Test
    public void unsuccesfulCheckoutBookWhenBookAlreadyCheckedOut(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Book b = l.infoBook("Lo que el viento se llevo");
        b.setCheckedOut(true);

        l.checkOutBook("Lo que el viento se llevo");

        StringWriter expectedStringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(expectedStringWriter);
        printWriter.println("Sorry, that book is not available");
        String expected = expectedStringWriter.toString();

        assertEquals(expected,outContent.toString());
    }

    @Test
    public void successfulReturnBookWhenBookIsAlreadyCheckedout(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Book b = l.infoBook("Lo que el viento se llevo");
        b.setCheckedOut(true);
        l.returnBook("Lo que el viento se llevo");

        StringWriter expectedStringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(expectedStringWriter);
        printWriter.println("Thank you for returning the book");
        String expected = expectedStringWriter.toString();

        assertEquals(expected,outContent.toString());
    }

    @Test
    public void unsuccessfulReturnBookWhenABookIsNotCheckedout(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        l.returnBook("Lo que el viento se llevo");

        StringWriter expectedStringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(expectedStringWriter);
        printWriter.println("That is not a valid book to return");
        String expected = expectedStringWriter.toString();

        assertEquals(expected,outContent.toString());
    }

    @Test
    public void unsuccessfulReturnBookWhenSpellingTitleWrong(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Book b = l.infoBook("Lo que el viento se llevo");
        b.setCheckedOut(true);
        l.returnBook("Lo que el veinto se llevo");

        StringWriter expectedStringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(expectedStringWriter);
        printWriter.println("That is not a valid book to return");
        String expected = expectedStringWriter.toString();

        assertEquals(expected,outContent.toString());
    }

}
