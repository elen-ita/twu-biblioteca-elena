package com.twu.biblioteca;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class Printer {

    protected Scanner in;
    protected PrintStream out;
    protected Library library;

    public Printer(InputStream input, OutputStream output, Library library) {
        this.in = new Scanner(input);
        this.out = new PrintStream(output);
        this.library = library;
    }

    public String getInputLine() {
        return in.next().toString();
    }

    public void processOutput(String outputString) {
        out.print(outputString);
        out.flush();
    }

    public void printMainMenu(List<String> menu, String userLoggedIn) {
        processOutput("Main Menu: \n");
        processOutput("-----------------------\n");
        for (int i = 0; i < menu.size(); i++){
            processOutput("Option " + i + ": " + menu.get(i) + "\n");
        }
        if(userLoggedIn != null){
            processOutput("Option " + menu.size() + ": See Your User Info\n");
        }
        processOutput("-----------------------\n");
    }

    public void printWelcomeMessage() {
        processOutput("Hello, Welcome to Biblioteca!\n");
    }

    public void printUser(User user) {
        processOutput("Name:\t" + user.getName() + "\n");
        processOutput("Email:\t" + user.getEmail() + "\n");
        processOutput("Phone:\t" + user.getPhone() + "\n");
    }

    public void printBookList() {
        processOutput(String.format("%-35s%-25s%-4s\n", "Title", "Author", "Year"));
        processOutput("----------------------------------------------------------------\n");
        for (Media item : library.getMedia()){
            if(item instanceof Book && item.getCheckedOutTo() == null){
                processOutput(item.toString());
            }
        }
        processOutput("----------------------------------------------------------------\n");
    }

    public void printMovieList() {
        processOutput(String.format("%-35s%-25s%-10s%-6s\n", "Title", "Director", "Year", "Rating"));
        processOutput("----------------------------------------------------------------------------\n");
        for (Media item : library.getMedia()){
            if(item instanceof Movie && item.getCheckedOutTo() == null){
                processOutput(item.toString());
            }
        }
        processOutput("----------------------------------------------------------------------------\n");
    }

}
