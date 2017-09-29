package com.twu.biblioteca;

public abstract class Media {

    protected String title;
    protected String creator;
    protected int year;
    protected String checkedOutTo;

    public Media (String title, String creator, int year, String checkedOutTo){
        this.title = title;
        this.creator = creator;
        this.year = year;
        this.checkedOutTo = checkedOutTo;
    }

    public void setCheckedOutTo(String newCheckedOut){
        this.checkedOutTo = newCheckedOut;
    }

    public String getTitle(){
        return title;
    }

    public String getCheckedOutTo(){
        return checkedOutTo;
    }

    public boolean isSameMedia(Media otherMedia){
        return (this.title == otherMedia.title &&
                this.creator == otherMedia.creator &&
                this.year == otherMedia.year &&
                this.checkedOutTo == otherMedia.checkedOutTo);
    }

}
