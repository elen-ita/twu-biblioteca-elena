package com.twu.biblioteca;

public class Book extends Media {

    public Book(String title, String creator, int year, String checkedOutTo) {
        super(title, creator, year, checkedOutTo);
    }

    public String toString() {
        return String.format("%-35s%-25s%-4s\n", this.title, this.creator, this.year);
    }

}
