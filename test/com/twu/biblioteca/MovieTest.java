package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
    private Movie mb;
    @Before
    public void setUp() {
        mb = new Movie("Malditos bastardos", 2008, "Quentin Tarantino", 10);
    }
    @Test
    public void changeCheckedOutAttributeWhenCheckoutMovie() {
        mb.checkOut();
        assertEquals(true, mb.getCheckedout());
    }

    @Test
    public void notChangeCheckedoutAttributeWhenTryToCheckoutMovieThatIsAlreadyCheckedOut() {
        mb.setCheckedout(true);
        mb.checkOut();
        assertEquals(true, mb.getCheckedout());
    }
}
