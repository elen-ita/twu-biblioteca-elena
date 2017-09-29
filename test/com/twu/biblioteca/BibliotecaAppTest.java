package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class BibliotecaAppTest {

    @Test
    public void TestUsersAreInitialized() throws Exception {
        ByteArrayOutputStream outSpy = new ByteArrayOutputStream();
        FakePrinter printer = new FakePrinter(System.in, new PrintStream(outSpy), null);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(printer);

        assertEquals("Bob Smith", bibliotecaApp.users.get(0).name);
    }

    @Test
    public void TestCheckOutFromLibrary() throws Exception {
        ByteArrayOutputStream outSpy = new ByteArrayOutputStream();
        Library library = new Library();
        FakePrinter printer = new FakePrinter(System.in, new PrintStream(outSpy), library);
        ArrayList<String> options = new ArrayList();
        options.add("3");
        options.add("bsmith");
        options.add("123");
        options.add("Lolita");
        options.add("0");
        printer.setUserResponses(options);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(printer);

        bibliotecaApp.mainMenu();

        assertTrue(outSpy.toString().contains("Thank you! Enjoy the book"));


    }



    public class FakePrinter extends Printer {
        private ArrayList<String> userOption;

        public FakePrinter(InputStream input, OutputStream output, Library library) {
            super(input, output, library);
        }

        public void setUserResponses(ArrayList<String> userOptions) {

            this.userOption = userOptions;
        }

        @Override
        public String getInputLine() {
            return userOption.remove(0);
        }
    }
}


