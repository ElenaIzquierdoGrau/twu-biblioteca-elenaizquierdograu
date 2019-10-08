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

    public void printAllBooks() {
        System.out.println("Here you have the list of all the books in the library");
        String first_line = "|      Title            |       Author      |   Year  |";
        System.out.println(first_line);
        for (Book b : books) {
            String line = "";
            line = line + b.title + " | " + b.author + " | " + b.year;
            System.out.println(line);
        }
    }

    public void listAvailableBooks(){
        ArrayList<Book> availableBooks = new ArrayList<Book>();
        for (Book book : books) {
            if (!book.checkedOut) {
                availableBooks.add(book);
            }
        }
        System.out.println("Here you have the list of available books of the library");
        String first_line = "|      Title            |       Author      |   Year  |";
        System.out.println(first_line);
        for (Book ab : availableBooks) {
            String line = "";
            line = line + ab.title + " | " + ab.author + " | " + ab.year;
            System.out.println(line);
        }
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
