package com.twu.biblioteca;
import java.util.ArrayList;

public class Library {
    ArrayList<Book> books;

    public Library() {
        books = new ArrayList<Book>();
        Book a = new Book("Lo que el viento se llevo",1997,"Elena Izquierdo");
        Book b = new Book("La sombra del viento",2017,"Elena Grau");
        this.books.add(a);
        this.books.add(b);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Book> getAvailableBooks(){
        ArrayList<Book> availableBooks = new ArrayList<Book>();
        for (Book book : books) {
            if (!book.checkedOut) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public void checkOutBook(String title){
        boolean found = false;
        for (Book book : books) {
            if(!found) {
                if (book.title.equals(title)) {
                    book.checkOut();
                    found = true;
                }
            }
        }
        if(!found) System.out.println("Sorry, that book is not available");
    }
    public void returnBook(String title){
        boolean found = false;
        for (Book book : books) {
            if(!found) {
                if (book.title.equals(title)) {
                    book.returnBook();
                    found = true;
                }
            }
        }
        if(!found) System.out.println("That is not a valid book to return");
    }

    public Book infoBook(String title){
        for (Book book : books) {
            if (book.title.equals(title)) {
                return book;
            }
        }
        System.out.println("Book not found");
        return null;
    }
}
