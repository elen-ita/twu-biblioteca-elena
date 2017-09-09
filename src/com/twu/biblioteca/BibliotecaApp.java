package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

        System.out.println(welcomeMessage());
        System.out.println();
        System.out.println(mainMenu());

    }



    public static String welcomeMessage() {
        return "Hello, Welcome to Biblioteca!";
    }

    public static String mainMenu() {
        return "Option 1: List Books";
    }
}
