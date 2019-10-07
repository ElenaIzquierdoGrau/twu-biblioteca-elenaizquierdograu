package com.twu.biblioteca;
import java.util.ArrayList;

public class Library {
    ArrayList<Book> books;

    public Library() {
        books = new ArrayList<Book>();
        Book a = new Book("Lo que el viento se llevo");
        Book b = new Book("La sombra del viento");
        this.books.add(a);
        this.books.add(b);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
