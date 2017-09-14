package com.twu.biblioteca;

import java.util.*;


public class BibliotecaApp {

    private static List<String> menu = new ArrayList<String>()
    {{
        add("Quit");
        add("List Books");
        add("List Movies");
        add("Checkout Book");
        add("Return Book");
        add("Checkout Movie");
        add("Return Movie");
    }};



    public static void main(String[] args) {
        System.out.println(welcomeMessage() + "\n");
        mainMenu();
    }




    public static String welcomeMessage() {
        return "Hello, Welcome to Biblioteca!";
    }

    private static void mainMenu() {
        do {
            displayMainMenu();
        }while(decideMainMenuAction(readUserChoice()));
    }

    private static void displayMainMenu() {
        System.out.println("Main Menu: ");
        System.out.println("-----------------------");
        for (int i = 0; i < menu.size(); i++){
            System.out.println("Option " + i + ": " + menu.get(i));
        }
        System.out.println("-----------------------");
    }

    private static Boolean decideMainMenuAction(String userChoice) {
        if (userChoice.equals("0")){
            return false;
        }
        else if(userChoice.equals("1")){
            Library.printBookList();
            return true;
        }
        else if(userChoice.equals("2")){
            Library.printMovieList();
            return true;
        }
        else if (userChoice.equals("3")) {
            System.out.println(checkOutFromLibrary("book"));
            return true;
        }
        else if (userChoice.equals("4")) {
            System.out.println(returnToLibrary("book"));
            return true;
        }
        else if (userChoice.equals("5")) {
            System.out.println(checkOutFromLibrary("movie"));
            return true;
        }
        else if (userChoice.equals("6")) {
            System.out.println(returnToLibrary("movie"));
            return true;
        }
        else{
            System.out.println("Select a valid option!");
            return true;
        }
    }

    public static String returnToLibrary(String mediaType) {
        System.out.print("Please type the title of the " + mediaType + " you would like to return: ");
        if(Library.returnItem(readUserChoice())){
            return "Thank you for returning the " + mediaType;
        } else {
            return "That is not a valid " + mediaType + " return";
        }
    }

    public static String checkOutFromLibrary(String mediaType) {
        System.out.print("Please type the title of the " + mediaType + " you would like to checkout: ");
        if(Library.checkOutItem(readUserChoice())){
            return "Thank you! Enjoy the " + mediaType;
        } else {
            return "That " + mediaType + " is not available";
        }
    }

    private static String readUserChoice() {
        Scanner reader = new Scanner(System.in);
        return reader.next().toString();
    }
}
