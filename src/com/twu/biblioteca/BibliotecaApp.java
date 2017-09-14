package com.twu.biblioteca;

import java.util.*;


public class BibliotecaApp {

    private static List<String> menu = new ArrayList<String>()
    {{
        add("Quit");
        add("List Books");
        add("Checkout Book");
        add("Return Book");
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
        else if (userChoice.equals("2")) {
            System.out.print("Please type the title of the book you would like to checkout: ");
            System.out.println(Library.checkOutBook(readUserChoice()));
            return true;
        }
        else if (userChoice.equals("3")) {
            System.out.print("Please type the title of the book you would like to return: ");
            System.out.println(Library.returnBook(readUserChoice()));
            return true;
        }
        else{
            System.out.println("Select a valid option!");
            return true;
        }
    }

    public static String readUserChoice() {
        Scanner reader = new Scanner(System.in);
        return reader.next().toString();
    }
}
