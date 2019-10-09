package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void changeCheckedOutAttributeWhenCheckoutBook() {
        Book book = new Book("Lo que el viento se llevo",1997,"Elena Izquierdo");
        book.checkOut();
        assertEquals(true, book.getCheckedOut());
    }

    @Test
    public void notChangeCheckedoutAttributeWhenTryToCheckoutBookThatIsAlreadyCheckedOut() {
        Book book = new Book("Lo que el viento se llevo",1997,"Elena Izquierdo");
        book.setCheckedOut(true);
        book.checkOut();
        assertEquals(true, book.getCheckedOut());
    }

    @Test
    public void changeCheckedOutAttributeWhenReturnBook() {
        Book book = new Book("Lo que el viento se llevo",1997,"Elena Izquierdo");
        book.setCheckedOut(true);
        book.returnBook();
        assertEquals(false, book.getCheckedOut());
    }

    @Test
    public void notChangeCheckedoutAttributeWhenTryToReturnBookThatIsNotCheckedOut() {
        Book book = new Book("Lo que el viento se llevo",1997,"Elena Izquierdo");
        book.returnBook();
        assertEquals(false, book.getCheckedOut());
    }
}
