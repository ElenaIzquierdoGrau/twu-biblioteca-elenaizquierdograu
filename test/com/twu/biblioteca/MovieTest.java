package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
    @Test
    public void changeCheckedOutAttributeWhenCheckoutMovie() {
        Movie mb = new Movie("Malditos bastardos", 2008, "Quentin Tarantino",10);
        mb.checkOut();
        assertEquals(true, mb.getCheckedout());
    }

    @Test
    public void notChangeCheckedoutAttributeWhenTryToCheckoutMovieThatIsAlreadyCheckedOut() {
        Movie mb = new Movie("Malditos bastardos", 2008, "Quentin Tarantino",10);
        mb.setCheckedout(true);
        mb.checkOut();
        assertEquals(true, mb.getCheckedout());
    }
}
