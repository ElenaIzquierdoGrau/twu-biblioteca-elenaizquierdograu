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
        for(int i = 0; i<books.size(); i++) {
            if(!books.get(i).checkedOut){
                availableBooks.add(books.get(i));
            }
        }
        return availableBooks;
    }

    public void checkOutBook(String title){
        for(int i = 0; i<books.size(); i++) {
            if(books.get(i).title.equals(title)){
                books.get(i).checkOut();
            }
        }
    }
}
