package com.twu.biblioteca;

import java.util.*;
import com.twu.biblioteca.Book;

public class BibliotecaApp {

    private static ArrayList<Book> books = new ArrayList<Book>()
    {{
        add(new Book("The Great Gatsby","F. Scott Fitzgerald", 1925));
        add(new Book("The Grapes of Wrath", "John Steinbeck", 1939));
        add(new Book("Nineteen Eighty-Four","George Orwell", 1949));
        add(new Book("Ulysses", "James Joyce", 1918));
        add(new Book("Lolita", "Vladimir Nabakov", 1955));
        add(new Book("Catch-22", "Joseph Heller", 1961));
        add(new Book("The Catcher in the Rye", "J.D. Salinger", 1951));
        add(new Book("Beloved", "Toni Morrison", 1987));
        add(new Book("To Kill a Mockingbird", "Harper Lee", 1960));
        add(new Book("One Hundred Years of Solitude", "J. R. R. Tolkien", 1954));
    }};

    public static void main(String[] args) {

        System.out.println(welcomeMessage() + "\n");

        mainMenu();

    }


    public static String welcomeMessage() {
        return "Hello, Welcome to Biblioteca!";
    }

    public static void mainMenu() {
        System.out.println(displayMainMenu());
        decideMainMenuAction(readUserChoice());
    }

    public static void decideMainMenuAction(int userChoice) {
        if(userChoice != 1){
            System.out.println("Select a valid option!");
        }else{
            printBookList();
        }
    }

    public static void printBookList() {
        System.out.printf("%-35s%-25s%-4s\n", "Title", "Author", "Year");
        System.out.println("----------------------------------------------------------------");
        for (Book book : books){
            System.out.printf("%-35s%-25s%-4s\n", book.getTitle(), book.getAuthor(), book.getDatePublished());
        }
    }

    private static int readUserChoice() {
        Scanner reader = new Scanner(System.in);
        return reader.nextInt();
    }

    public static String displayMainMenu() {
        return "Option 1: List Books";
    }
}
