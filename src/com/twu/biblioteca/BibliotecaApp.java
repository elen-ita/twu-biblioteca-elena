package com.twu.biblioteca;

import java.util.*;
import com.twu.biblioteca.Library;

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
            if(Library.checkOutBook(readUserChoice())){
                System.out.println("Thank you! Enjoy the book");
            } else {
                System.out.println("That book is not available");
            }
            return true;
        }
        else if (userChoice.equals("3")) {
            System.out.print("Please type the title of the book you would like to return: ");
            if(Library.returnBook(readUserChoice())){
                System.out.println("Thank you for returning the book");
            } else {
                System.out.println("That is not a valid book return");
            }
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
