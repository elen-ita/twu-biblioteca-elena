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
    public void testCheckOutAvailableBook() {
        Library.checkOutBook("Lolita");
        assertEquals(true, Library.findBook("Lolita").getCheckedOut());
    }

    @Test
    public void testCheckOutAlreadyCheckedOutBook() {
        Library.checkOutBook("Lolita");
        assertEquals("That book is not available", Library.checkOutBook("Lolita"));
        assertEquals(true, Library.findBook("Lolita").getCheckedOut());
    }

    @Test
    public void testCheckOutNonexistantBook() {
        assertEquals("That book is not available", Library.checkOutBook("Not a Book"));
    }

    @Test
    public void testReturnCorrectBook() {
        Library.checkOutBook("Lolita");
        Library.returnBook("Lolita");
        assertEquals(false, Library.findBook("Lolita").getCheckedOut());
    }

    @Test
    public void testReturnNonexistantBook() {
        assertEquals("That is not a valid book return", Library.returnBook("Not a Book"));
    }

    @Test
    public void testReturnBookThatHasNotBeenCheckedOut() {
        assertEquals("That is not a valid book return", Library.returnBook("Lolita"));
        assertEquals(false, Library.findBook("Lolita").getCheckedOut());
    }

}
