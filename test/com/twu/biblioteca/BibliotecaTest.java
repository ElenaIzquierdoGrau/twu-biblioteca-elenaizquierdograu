package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BibliotecaTest {
    BibliotecaApp bibliotecaApp = new BibliotecaApp();

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


}
