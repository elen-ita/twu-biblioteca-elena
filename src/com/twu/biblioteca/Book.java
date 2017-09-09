package com.twu.biblioteca;



public class Book {

    private String title;
    private String author;
    private int datePublished;

    public Book (String title, String author, int datePublished){
        this.title = title;
        this.author = author;
        this.datePublished = datePublished;
    }

    public void setTitle(String newTitle){
        this.title = newTitle;
    }

    public void setAuthor(String newAuthor){
        this.author = newAuthor;
    }

    public void setDatePublished(int newDate){
        this.datePublished = newDate;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public int getDatePublished(){
        return datePublished;
    }
}
