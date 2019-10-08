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
        for (Book book : books) {
            if (book.title.equals(title)) {
                book.checkOut();
                break;
            }
        }
        System.out.println("Sorry, that book is not available");
    }
    public void returnBook(String title){
        for (Book book : books) {
            if (book.title.equals(title)) {
                book.returnBook();
                break;
            }
        }
        System.out.println("That is not a valid book to return");
    }
}
