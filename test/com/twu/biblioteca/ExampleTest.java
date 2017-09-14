package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void testWelcomeMessage() {
        assertEquals("Hello, Welcome to Biblioteca!", BibliotecaApp.welcomeMessage());
    }

   // @Test
    //public void testMainMenu() {
     //   assertEquals("Option 1: List Books", com.twu.biblioteca.BibliotecaApp.displayMainMenu());
    //}

    //Does every method have to return something?
    //I'm Unsure of how to test void methods for ex methods that only print stuff

    @Test
    public void testCheckOutItemAvailable() {
        Library.checkOutItem("Lolita");
        assertEquals(true, Library.find("Lolita").getCheckedOut());
    }

    @Test
    public void testCheckOutItemAlreadyCheckedOut() {
        Library.checkOutItem("Lolita");
        assertEquals(false, Library.checkOutItem("Lolita"));
        assertEquals(true, Library.find("Lolita").getCheckedOut());
    }

    @Test
    public void testCheckOutItemNonexistant() {
        assertEquals(false, Library.checkOutItem("Not a Book"));
    }

    @Test
    public void testReturnItemCorrect() {
        Library.checkOutItem("Lolita");
        Library.returnItem("Lolita");
        assertEquals(false, Library.find("Lolita").getCheckedOut());
    }

    @Test
    public void testReturnItemNonexistant() {
        assertEquals(false, Library.returnItem("Not a Book"));
    }

    @Test
    public void testReturnItemNotCheckedOut() {
        assertEquals(false, Library.returnItem("Lolita"));
        assertEquals(false, Library.find("Lolita").getCheckedOut());
    }


}
