package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class BibliotecaTest {
    private BibliotecaApp bibliotecaApp = new BibliotecaApp();
    private Library l = new Library();

    @Test
    public void welcomeMessageTest() {
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", bibliotecaApp.getWelcomeMessage());
    }

    @Test
    public void listBooksTest() {
        ArrayList<Book> books_expected = new ArrayList<Book>();
        Book a = new Book("Lo que el viento se llevo",1997,"Elena Izquierdo");
        Book b = new Book("La sombra del viento",2017,"Elena Grau");
        books_expected.add(a);
        books_expected.add(b);

        ArrayList<Book> books;
        books = bibliotecaApp.getBooks();

        for(int i = 0; i<books.size(); i++){
            assertEquals(books_expected.get(i).title,books.get(i).title);
            assertEquals(books_expected.get(i).year,books.get(i).year);
            assertEquals(books_expected.get(i).author,books.get(i).author);
        }


    }

    @Test(expected=InvalidMenuOptionException.class)
    public void illegalOptionMenu() throws InvalidMenuOptionException{
        ArrayList<Book> books;
        books = bibliotecaApp.menu.choseOption("Profile");
    }

    @Test
    public void quitApplicationTest() throws InvalidMenuOptionException{
        ArrayList<Book> books;
        books = bibliotecaApp.menu.choseOption("Quit");
        assertNull(books);
    }

    @Test
    public void listBooksFromMenuTest() throws InvalidMenuOptionException{
        ArrayList<Book> books_expected = new ArrayList<Book>();
        Book a = new Book("Lo que el viento se llevo",1997,"Elena Izquierdo");
        Book b = new Book("La sombra del viento",2017,"Elena Grau");
        books_expected.add(a);
        books_expected.add(b);

        ArrayList<Book> books;
        books = bibliotecaApp.menu.choseOption("List of books");

        for(int i = 0; i<books.size(); i++){
            assertEquals(books_expected.get(i).title,books.get(i).title);
            assertEquals(books_expected.get(i).year,books.get(i).year);
            assertEquals(books_expected.get(i).author,books.get(i).author);
        }
    }

    @Test
    public void listBooksNotCheckedOutFromMenuTest() throws InvalidMenuOptionException{
        ArrayList<Book> books_expected = new ArrayList<Book>();
        Book a = new Book("Lo que el viento se llevo",1997,"Elena Izquierdo");
        books_expected.add(a);

        bibliotecaApp.menu.l.checkOutBook("La sombra del viento");
        ArrayList<Book> books;
        books = bibliotecaApp.menu.choseOption("List of books");

        for(int i = 0; i<books.size(); i++){
            assertEquals(books_expected.get(i).title,books.get(i).title);
            assertEquals(books_expected.get(i).year,books.get(i).year);
            assertEquals(books_expected.get(i).author,books.get(i).author);
        }
    }

    @Test
    public void successfulCheckOutBookTest(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Book book = new Book("Lo que el viento se llevo",1997,"Elena Izquierdo");
        book.checkOut();
        assertEquals(true, book.getCheckedOut());

        StringWriter expectedStringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(expectedStringWriter);
        printWriter.println("Thank you! Enjoy the book");
        String expected = expectedStringWriter.toString();

        assertEquals(expected,outContent.toString());
    }

    @Test
    public void unavailableCheckOutBookTest(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Book book = new Book("Lo que el viento se llevo",1997,"Elena Izquierdo");
        book.setCheckedOut(true);
        book.checkOut();
        assertEquals(true, book.getCheckedOut());

        StringWriter expectedStringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(expectedStringWriter);
        printWriter.println("Sorry, that book is not available");
        String expected = expectedStringWriter.toString();

        assertEquals(expected,outContent.toString());
    }

    @Test
    public void wrongSpellingCheckOutBookTest(){
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
    public void successfulReturnBookTest(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Book book = new Book("Lo que el viento se llevo",1997,"Elena Izquierdo");
        book.setCheckedOut(true);
        book.returnBook();
        assertEquals(false, book.getCheckedOut());

        StringWriter expectedStringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(expectedStringWriter);
        printWriter.println("Thank you for returning the book");
        String expected = expectedStringWriter.toString();

        assertEquals(expected,outContent.toString());
    }

    @Test
    public void unavailableReturnBookTest(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Book book = new Book("Lo que el viento se llevo",1997,"Elena Izquierdo");
        book.returnBook();

        StringWriter expectedStringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(expectedStringWriter);
        printWriter.println("That is not a valid book to return");
        String expected = expectedStringWriter.toString();

        assertEquals(expected,outContent.toString());
    }

    @Test
    public void wrongSpellingReturnBookTest(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        l.returnBook("Lo que el veinto se llevo");

        StringWriter expectedStringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(expectedStringWriter);
        printWriter.println("That is not a valid book to return");
        String expected = expectedStringWriter.toString();

        assertEquals(expected,outContent.toString());
    }


}
