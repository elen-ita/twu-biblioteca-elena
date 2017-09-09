package com.twu.biblioteca;


import org.junit.Test;
import com.twu.biblioteca.BibliotecaApp;
import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void testWelcomeMessage() {
        assertEquals("Hello, Welcome to Biblioteca!", com.twu.biblioteca.BibliotecaApp.welcomeMessage());
    }

    @Test
    public void testMainMenu() {
        assertEquals("Option 1: List Books", com.twu.biblioteca.BibliotecaApp.displayMainMenu());
    }

    //Does every method have to return something?
    //I'm Unsure of how to test void methods or methods that require user input
}
