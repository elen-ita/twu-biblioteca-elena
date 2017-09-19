package com.twu.biblioteca;


import java.util.ArrayList;


public class Library {


    private ArrayList<Media> media = new ArrayList<Media>()
    {{
        add(new Media("The Great Gatsby","F. Scott Fitzgerald", 1925,"Book", null));
        add(new Media("The Grapes of Wrath", "John Steinbeck", 1939, "Book", null));
        add(new Media("Nineteen Eighty-Four","George Orwell", 1949, "Book",null));
        add(new Media("Ulysses", "James Joyce", 1918, "Book",null));
        add(new Media("Lolita", "Vladimir Nabakov", 1955, "Book",null));
        add(new Media("Catch-22", "Joseph Heller", 1961, "Book",null));
        add(new Media("The Catcher in the Rye", "J.D. Salinger", 1951,"Book", null));
        add(new Media("Beloved", "Toni Morrison", 1987, "Book",null));
        add(new Media("To Kill a Mockingbird", "Harper Lee", 1960, "Book",null));
        add(new Media("One Hundred Years of Solitude", "J. R. R. Tolkien", 1954, "Book",null));
        add(new Media("The Wizard of Oz", "King Vidor", 1939, 9.4, "Movie", null));
        add(new Media("Jaws", "Stephen Spielberg", 1975, 9.2, "Movie",  null));
    }};


    public ArrayList<Media> getMedia(){
        return media;
    }

    public boolean returnItem(String userChoice){
        Media selectedItem = find(userChoice);
        if(selectedItem != null && selectedItem.getCheckedOutTo() != null){
            selectedItem.setCheckedOutTo(null);
            return true;
        } else {
            return false;
        }
    }

    public boolean checkOutItem(String userChoice, String user){
        Media selectedItem = find(userChoice);
        if(selectedItem != null && selectedItem.getCheckedOutTo() == null){
            selectedItem.setCheckedOutTo(user);
            return true;
        } else {
            return false;
        }
    }

    public Media find(String userChoice){
        for(Media item : media){
            if (item.getTitle().equals(userChoice)){
                return item;
            }
        }
        return null;
    }
}


