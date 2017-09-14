package com.twu.biblioteca;



public class Media {

    protected String title;
    protected String creator;
    protected int year;
    protected double rating;
    protected String mediaType;
    protected boolean checkedOut;


    public Media (String title, String creator, int year, String mediaType, boolean checkedOut){
        this.title = title;
        this.creator = creator;
        this.year = year;
        this. mediaType = mediaType;
        this.checkedOut = checkedOut;
    }

    public Media (String title, String creator, int year, double rating, String mediaType, boolean checkedOut){
        this.title = title;
        this.creator = creator;
        this.year = year;
        this.rating = rating;
        this. mediaType = mediaType;
        this.checkedOut = checkedOut;
    }

    public void setCheckedOut(boolean newCheckedOut){
        this.checkedOut = newCheckedOut;
    }

    public String getTitle(){
        return title;
    }

    public String getCreator(){
        return creator;
    }

    public int getYear(){
        return year;
    }

    public double getRating(){ return rating; }

    public String getMediaType() { return mediaType; }

    public boolean getCheckedOut(){
        return checkedOut;
    }
}
