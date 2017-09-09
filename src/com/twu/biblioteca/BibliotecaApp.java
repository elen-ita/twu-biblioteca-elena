package com.twu.biblioteca;

import java.util.*;

public class BibliotecaApp {

    static final List<String> books = new ArrayList<String>()
    {{
        add("The Great Gatsby");
        add("The Grapes of Wrath");
        add("Nineteen Eighty-Four");
        add("Ulysses");
        add("Lolita");
        add("Catch-22");
        add("The Catcher in the Rye");
        add("Beloved");
        add("To Kill a Mockingbird");
        add("One Hundred Years of Solitude");
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

    private static void decideMainMenuAction(int userChoice) {
        printBookList();
    }

    public static void printBookList() {
        for (String book : books){
                 System.out.println(book);
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
