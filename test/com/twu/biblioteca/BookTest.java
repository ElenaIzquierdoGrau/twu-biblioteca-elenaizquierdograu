package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    private Book book;
    @Before
    public void setUp() {
        book = new Book("Lo que el viento se llevo",1997,"Elena Izquierdo");
    }

    @Test
    public void changeCheckedOutAttributeWhenCheckoutBook() {
        book.checkOut("111-1111");
        assertEquals(true, book.getCheckedOut());
    }

    @Test
    public void notChangeCheckedoutAttributeWhenTryToCheckoutBookThatIsAlreadyCheckedOut() {
        book.setCheckedOut(true);
        book.checkOut("111-1111");
        assertEquals(true, book.getCheckedOut());
    }

    @Test
    public void changeCheckedOutAttributeWhenReturnBook() {
        book.setCheckedOut(true);
        book.returnBook();
        assertEquals(false, book.getCheckedOut());
    }

    @Test
    public void notChangeCheckedoutAttributeWhenTryToReturnBookThatIsNotCheckedOut() {
        book.returnBook();
        assertEquals(false, book.getCheckedOut());
    }

    @Test
    public void libraryNumberIsLinkedInBookWhenCheckouBook() {
        book.checkOut("111-1111");
        assertEquals("111-1111",book.getLibraryNumberFromUser());
    }

    @Test
    public void libraryNumberMustBeNullWhenReturnBook() {
        book.checkOut("111-1111");
        book.returnBook();
        assertNull(book.getLibraryNumberFromUser());
    }

    @Test
    public void libraryNumberIsNullWhenCreateBook() {
        assertNull(book.getLibraryNumberFromUser());
    }
}
