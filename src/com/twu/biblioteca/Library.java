package com.twu.biblioteca;


import java.util.ArrayList;

public class Library {

    public static ArrayList<Media> media = new ArrayList<Media>()
    {{
        add(new Media("The Great Gatsby","F. Scott Fitzgerald", 1925,"Book", false));
        add(new Media("The Grapes of Wrath", "John Steinbeck", 1939, "Book", false));
        add(new Media("Nineteen Eighty-Four","George Orwell", 1949, "Book",false));
        add(new Media("Ulysses", "James Joyce", 1918, "Book",false));
        add(new Media("Lolita", "Vladimir Nabakov", 1955, "Book",false));
        add(new Media("Catch-22", "Joseph Heller", 1961, "Book",false));
        add(new Media("The Catcher in the Rye", "J.D. Salinger", 1951,"Book", false));
        add(new Media("Beloved", "Toni Morrison", 1987, "Book",false));
        add(new Media("To Kill a Mockingbird", "Harper Lee", 1960, "Book",false));
        add(new Media("One Hundred Years of Solitude", "J. R. R. Tolkien", 1954, "Book",false));
        add(new Media("The Wizard of Oz", "King Vidor", 1939, 9.4, "Movie", false));
        add(new Media("Jaws", "Stephen Spielberg", 1975, 9.2, "Movie",  false));
    }};


    public static void printBookList() {
        System.out.printf("%-35s%-25s%-4s\n", "Title", "Author", "Year");
        System.out.println("----------------------------------------------------------------");
        for (Media item : media){
            if(!item.getCheckedOut() && item.getMediaType().equals("Book")){
                System.out.printf("%-35s%-25s%-4s\n", item.getTitle(), item.getCreator(), item.getYear());
            }
        }
        System.out.println("----------------------------------------------------------------");
    }

    public static void printMovieList() {
        System.out.printf("%-35s%-25s%-10s%-6s\n", "Title", "Director", "Year", "Rating");
        System.out.println("----------------------------------------------------------------------------");
        for (Media item : media){
            if(!item.getCheckedOut() && item.getMediaType().equals("Movie")){
                System.out.printf("%-35s%-25s%-10s%6s\n", item.getTitle(), item.getCreator(), item.getYear(), item.getRating());
            }
        }
        System.out.println("----------------------------------------------------------------------------");
    }



    public static boolean returnItem(String userChoice){
        Media selectedItem = find(userChoice);
        if(selectedItem != null && selectedItem.getCheckedOut()){
            selectedItem.setCheckedOut(false);
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkOutItem(String userChoice){
        Media selectedItem = find(userChoice);
        if(selectedItem != null && !selectedItem.getCheckedOut()){
            selectedItem.setCheckedOut(true);
            return true;
        } else {
            return false;
        }
    }

    public static Media find(String userChoice){
        for(Media item : media){
            if (item.getTitle().equals(userChoice)){
                return item;
            }
        }
        return null;
    }
}


