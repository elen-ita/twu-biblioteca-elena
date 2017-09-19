package com.twu.biblioteca;

import java.util.*;


public class BibliotecaApp {

    public Library library;
    private String userLoggedIn;

    public BibliotecaApp(){
        userLoggedIn = null;
        library = new Library();
        welcomeMessage();
        mainMenu();
    }

    public static void main(String[] args) {
        new BibliotecaApp();
    }

    private List<String> menu = new ArrayList<String>()
    {{
        add("Quit");
        add("List Books");
        add("List Movies");
        add("Checkout Book");
        add("Return Book");
        add("Checkout Movie");
        add("Return Movie");
    }};

    public ArrayList<User> users = new ArrayList<User>()
    {{
        add(new User("Bob Smith", "bsmith", "123", "bsmith@gmail.com", "123-456-7890"));
    }};



    public String getUserLoggedIn(){
        return userLoggedIn;
    }

    private void welcomeMessage() {
         System.out.println("Hello, Welcome to Biblioteca!\n");
    }

    public void logIn(){
        System.out.println("Please log in:\n" + "Enter your username: ");
        User user = findUser(readUserChoice());
        while(user == null){
            System.out.println("Please enter a valid username: ");
            user = findUser(readUserChoice());
        }
        System.out.println("Enter your password: ");
        while(!user.getPassword().equals(readUserChoice())) {
            System.out.println("Incorrect password, please try again: ");
        }
        userLoggedIn = user.userID;
    }

    public User findUser(String userID){
        for(User user : users){
            if (user.getUserID().equals(userID)){
                return user;
            }
        }
        return null;
    }

    private void mainMenu() {
        do {
            displayMainMenu();
        }while(decideMainMenuAction(readUserChoice()));
    }

    private void displayMainMenu() {
        System.out.println("Main Menu: ");
        System.out.println("-----------------------");
        for (int i = 0; i < menu.size(); i++){
            System.out.println("Option " + i + ": " + menu.get(i));
        }
        if(userLoggedIn != null){
            System.out.println("Option " + menu.size() + ": See your user info");
        }
        System.out.println("-----------------------");
    }

    private Boolean decideMainMenuAction(String userChoice) {
        if (userChoice.equals("0")){
            return false;
        }
        else if(userChoice.equals("1")){
            printBookList();
            return true;
        }
        else if(userChoice.equals("2")){
            printMovieList();
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
        else if (userChoice.equals("7")){
            if (userLoggedIn == null){
                System.out.println("Select a valid option!");
            }
            showUserInfo();
            return true;
        }
        else{
            System.out.println("Select a valid option!");
            return true;
        }
    }

    private void showUserInfo(){
        User user = findUser(userLoggedIn);
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Phone: " + user.getPhone());
    }


    public String returnToLibrary(String mediaType) {
        if (userLoggedIn == null){
            logIn();
        }
        System.out.print("Please type the title of the " + mediaType + " you would like to return: ");
        if(library.returnItem(readUserChoice())){
            return "Thank you for returning the " + mediaType;
        } else {
            return "That is not a valid " + mediaType + " return";
        }
    }

    public String checkOutFromLibrary(String mediaType) {
        if (userLoggedIn == null){
            logIn();
        }
        System.out.print("Please type the title of the " + mediaType + " you would like to checkout: ");
        if(library.checkOutItem(readUserChoice(), userLoggedIn)){
            return "Thank you! Enjoy the " + mediaType;
        } else {
            return "That " + mediaType + " is not available";
        }
    }

    private String readUserChoice() {
        Scanner reader = new Scanner(System.in);
        return reader.next().toString();
    }

    public void printBookList() {
        System.out.printf("%-35s%-25s%-4s\n", "Title", "Author", "Year");
        System.out.println("----------------------------------------------------------------");
        for (Media item : library.getMedia()){
            if(item.getCheckedOutTo() == null && item.getMediaType().equals("Book")){
                System.out.printf("%-35s%-25s%-4s\n", item.getTitle(), item.getCreator(), item.getYear());
            }
        }
        System.out.println("----------------------------------------------------------------");
    }

    public void printMovieList() {
        System.out.printf("%-35s%-25s%-10s%-6s\n", "Title", "Director", "Year", "Rating");
        System.out.println("----------------------------------------------------------------------------");
        for (Media item : library.getMedia()){
            if(item.getCheckedOutTo() == null && item.getMediaType().equals("Movie")){
                System.out.printf("%-35s%-25s%-10s%6s\n", item.getTitle(), item.getCreator(), item.getYear(), item.getRating());
            }
        }
        System.out.println("----------------------------------------------------------------------------");
    }
}
