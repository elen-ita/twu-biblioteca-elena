package com.twu.biblioteca;



public class Media {

    protected String title;
    protected String creator;
    protected int year;
    protected double rating;
    protected String mediaType;
    protected String checkedOutTo;


    public Media (String title, String creator, int year, String mediaType, String checkedOutTo){
        this.title = title;
        this.creator = creator;
        this.year = year;
        this. mediaType = mediaType;
        this.checkedOutTo = checkedOutTo;
    }

    public Media (String title, String creator, int year, double rating, String mediaType, String checkedOutTo){
        this.title = title;
        this.creator = creator;
        this.year = year;
        this.rating = rating;
        this. mediaType = mediaType;
        this.checkedOutTo = checkedOutTo;
    }

    public void setCheckedOutTo(String newCheckedOut){
        this.checkedOutTo = newCheckedOut;
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

    public String getCheckedOutTo(){
        return checkedOutTo;
    }


    public boolean isSameMedia(Media otherMedia){
        return (this.title == otherMedia.title &&
                this.creator == otherMedia.creator &&
                this.year == otherMedia.year &&
                this. mediaType == otherMedia.mediaType &&
                this.checkedOutTo == otherMedia.checkedOutTo);
    }

}
