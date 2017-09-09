package com.twu.biblioteca;


import org.junit.Test;
import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.Library;
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
        assertEquals(true, Library.checkOutBook("Lolita"));
        boolean status = false;
        for(Book book : Library.books){
            if(book.getTitle().equals("Lolita")){
                status = book.getCheckedOut();
            }
        }
        assertEquals(true, status);
    }

    @Test
    public void testCheckOutAlreadyCheckedOutBook() {
        Library.checkOutBook("Lolita");
        assertEquals(false, Library.checkOutBook("Lolita"));
        boolean status = false;
        for(Book book : Library.books){
            if(book.getTitle().equals("Lolita")){
                status = book.getCheckedOut();
            }
        }
        assertEquals(true, status);
    }

    @Test
    public void testCheckOutNonexistantBook() {
        assertEquals(false, Library.checkOutBook("Not a Book"));
    }

    @Test
    public void testReturnCorrectBook() {
        Library.checkOutBook("Lolita");
        assertEquals(true, Library.returnBook("Lolita"));
        boolean status = true;
        for(Book book : Library.books){
            if(book.getTitle().equals("Lolita")){
                status = book.getCheckedOut();
            }
        }
        assertEquals(false, status);
    }


    @Test
    public void testReturnNonexistantBook() {
        assertEquals(false, Library.returnBook("Not a Book"));
    }


    @Test
    public void testReturnBookThatHasNotBeenCheckedOut() {
        assertEquals(false, Library.returnBook("Lolita"));
        boolean status = true;
        for(Book book : Library.books){
            if(book.getTitle().equals("Lolita")){
                status = book.getCheckedOut();
            }
        }
        assertEquals(false, status);
    }

}
