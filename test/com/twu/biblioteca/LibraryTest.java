package com.twu.biblioteca;

import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


public class LibraryTest {

    @Test
    public void testFindExistantItem(){
        Library myLib = new Library();
        Media lolita = new Book("Lolita", "Vladimir Nabakov", 1955, null);
        assertTrue(lolita.isSameMedia(myLib.find("Lolita")));
    }

    @Test
    public void testFindNonExistantItem(){
        Library myLib = new Library();
        assertNull(myLib.find("Nonexistant"));
    }

    @Test
    public void testCheckOutItemAvailable() {
        Library myLib = new Library();
        myLib.checkOutItem("Lolita", "111-1111");
        assertEquals("111-1111", myLib.find("Lolita").getCheckedOutTo());
    }

    @Test
    public void testCheckOutItemAlreadyCheckedOut() {
        Library myLib = new Library();
        myLib.checkOutItem("Lolita", "222-2222");
        assertEquals(false, myLib.checkOutItem("Lolita", "333-3333"));
        assertEquals("222-2222", myLib.find("Lolita").getCheckedOutTo());
    }

    @Test
    public void testCheckOutItemNonexistant() {
        Library myLib = new Library();
        assertEquals(false, myLib.checkOutItem("Not a Book", "444-4444"));
    }

    @Test
    public void testReturnItemCorrect() {
        Library myLib = new Library();
        myLib.checkOutItem("Lolita", "555-5555");
        myLib.returnItem("Lolita");
        assertEquals(null, myLib.find("Lolita").getCheckedOutTo());
    }

    @Test
    public void testReturnItemNonexistant() {
        Library myLib = new Library();
        assertEquals(false, myLib.returnItem("Not a Book"));
    }

    @Test
    public void testReturnItemNotCheckedOut() {
        Library myLib = new Library();
        assertEquals(false, myLib.returnItem("Lolita"));
        assertEquals(null, myLib.find("Lolita").getCheckedOutTo());
    }


}
