package com.twu.biblioteca;

public class Book extends Media {

    public Book (String title, String author, int datePublished, boolean checkedOut){
        this.title = title;
        this.creator = author;
        this.year = datePublished;
        this.checkedOut = checkedOut;
    }
}
