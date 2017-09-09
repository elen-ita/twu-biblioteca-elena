package com.twu.biblioteca;



public class Book {

    private String title;
    private String author;
    private int datePublished;
    private boolean checkedOut;

    public Book (String title, String author, int datePublished, boolean checkedOut){
        this.title = title;
        this.author = author;
        this.datePublished = datePublished;
        this.checkedOut = checkedOut;
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

    public void setCheckedOut(boolean newCheckedOut){
        this.checkedOut = newCheckedOut;
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

    public boolean getCheckedOut(){
        return checkedOut;
    }
}
