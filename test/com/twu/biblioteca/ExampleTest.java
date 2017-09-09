package com.twu.biblioteca;


import org.junit.Test;
import com.twu.biblioteca.BibliotecaApp;
import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void testWelcomeMessage() {
        assertEquals("Hello, Welcome to Biblioteca!", BibliotecaApp.welcomeMessage());
    }

    @Test
    public void testMainMenu() {
        assertEquals("Option 1: List Books", BibliotecaApp.mainMenu());
    }
}
