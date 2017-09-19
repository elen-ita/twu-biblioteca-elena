package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {

    protected ArrayList<Media> media;

    public Library() {
        initializeLibrary();
    }

    public void initializeLibrary() {
        media = new ArrayList<Media>();
        media.add(new Book("The Great Gatsby","F. Scott Fitzgerald", 1925, null));
        media.add(new Book("The Grapes of Wrath", "John Steinbeck", 1939,  null));
        media.add(new Book("Nineteen Eighty-Four","George Orwell", 1949, null));
        media.add(new Book("Ulysses", "James Joyce", 1918, null));
        media.add(new Book("Lolita", "Vladimir Nabakov", 1955, null));
        media.add(new Book("Catch-22", "Joseph Heller", 1961, null));
        media.add(new Book("The Catcher in the Rye", "J.D. Salinger", 1951,null));
        media.add(new Book("Beloved", "Toni Morrison", 1987, null));
        media.add(new Book("To Kill a Mockingbird", "Harper Lee", 1960, null));
        media.add(new Book("One Hundred Years of Solitude", "J. R. R. Tolkien", 1954, null));
        media.add(new Movie("The Wizard of Oz", "King Vidor", 1939, 9.4,  null));
        media.add(new Movie("Jaws", "Stephen Spielberg", 1975, 9.2, null));
    }

    public ArrayList<Media> getMedia(){
        return media;
    }

    public boolean returnItem(String userChoice){
        Media selectedItem = find(userChoice);
        if(selectedItem != null && selectedItem.getCheckedOutTo() != null) {
            selectedItem.setCheckedOutTo(null);
            return true;
        }
        return false;
    }

    public boolean checkOutItem(String userChoice, String user){
        Media selectedItem = find(userChoice);
        if(selectedItem != null && selectedItem.getCheckedOutTo() == null){
            selectedItem.setCheckedOutTo(user);
            return true;
        }
        return false;
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


