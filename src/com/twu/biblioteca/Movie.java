package com.twu.biblioteca;

public class Movie extends Media {

    protected double rating;

    public Movie(String title, String creator, int year, double rating, String checkedOutTo) {
        super(title, creator, year, checkedOutTo);
        this.rating = rating;
    }

    public double getRating(){ return rating; }

    public String toString() {
        return String.format("%-35s%-25s%-10s%6s\n", this.title, this.creator, this.year, this.rating);
    }
}
