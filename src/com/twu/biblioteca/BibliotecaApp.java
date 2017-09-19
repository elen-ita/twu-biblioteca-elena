package com.twu.biblioteca;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp bibApp = new BibliotecaApp(System.in, System.out);
        bibApp.mainMenu();
    }

    protected Library library;
    protected String userLoggedIn;
    protected List<String> menu;
    protected ArrayList<User> users;
    protected Printer printer;

    public BibliotecaApp(InputStream input, OutputStream output){
        library = new Library();
        printer = new Printer(input, output, library);
        initializeMenu();
        initializeUsers();
    }

    public void initializeUsers() {
        users = new ArrayList<User>();
        users.add(new User("Bob Smith", "bsmith", "123", "bsmith@gmail.com", "123-456-7890"));
    }

    public void initializeMenu() {
        menu = new ArrayList<String>();
        menu.add("Quit");
        menu.add("List Books");
        menu.add("List Movies");
        menu.add("Checkout Book");
        menu.add("Return Book");
        menu.add("Checkout Movie");
        menu.add("Return Movie");
    }

    public void mainMenu() {
        printer.printWelcomeMessage();
        do {
            printer.printMainMenu(menu, userLoggedIn);
        }while(decideMainMenuAction(readUserChoice()));
    }

    private Boolean decideMainMenuAction(String userChoice) {
        if (userChoice.equals("0")){
            printer.processOutput("Program terminating\n");
            return false;
        }
        switch(userChoice) {
            case "1": printer.printBookList();
                break;
            case "2": printer.printMovieList();
                break;
            case "3": printer.processOutput(checkOutFromLibrary("book"));
                break;
            case "4": printer.processOutput(returnToLibrary("book"));
                break;
            case "5": printer.processOutput(checkOutFromLibrary("movie"));
                break;
            case "6": printer.processOutput(returnToLibrary("movie"));
                break;
            case "7": if (userLoggedIn == null){
                        printer.processOutput("Select a valid option!\n");
                }
                showUserInfo();
                break;
            default: printer.processOutput("Select a valid option!\n");
        }
        return true;
    }

    private void logIn(){
        printer.processOutput("Please log in:\n" + "Enter your username: \n");
        User user = findUser(readUserChoice());
        while(user == null){
            printer.processOutput("Please enter a valid username: \n");
            user = findUser(readUserChoice());
        }
        printer.processOutput("Enter your password: \n");
        while(!user.getPassword().equals(readUserChoice())) {
            printer.processOutput("Incorrect password, please try again: \n");
        }
        userLoggedIn = user.userID;
    }

    private User findUser(String userID){
        for(User user : users){
            if (user.getUserID().equals(userID)){
                return user;
            }
        }
        return null;
    }

    private void showUserInfo(){
        User user = findUser(userLoggedIn);
        printer.printUser(user);
    }

    private String returnToLibrary(String mediaType) {
        if (userLoggedIn == null){
            logIn();
        }
        printer.processOutput("Please type the title of the " + mediaType + " you would like to return: \n");
        if(library.returnItem(readUserChoice())){
            return "Thank you for returning the " + mediaType + "\n";
        } else {
            return "That is not a valid " + mediaType + " return\n";
        }
    }

    private String checkOutFromLibrary(String mediaType) {
        if (userLoggedIn == null){
            logIn();
        }
        printer.processOutput("Please type the title of the " + mediaType + " you would like to checkout: \n");
        if(library.checkOutItem(readUserChoice(), userLoggedIn)){
            return "Thank you! Enjoy the " + mediaType + "\n";
        } else {
            return "That " + mediaType + " is not available\n";
        }
    }

    private String readUserChoice() {
        return printer.getInputLine();
    }
}
