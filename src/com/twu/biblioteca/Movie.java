package com.twu.biblioteca;

public class Movie extends Media {

    private double rating;

    public Movie (String title, String director, int yearMade, double rating, boolean checkedOut){
        this.title = title;
        this.creator = director;
        this.year = yearMade;
        this.rating = rating;
        this.checkedOut = checkedOut;
    }

    public double getRating(){ return rating; }
}
