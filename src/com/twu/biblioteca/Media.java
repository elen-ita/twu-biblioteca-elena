package com.twu.biblioteca;



public class Media {

    protected String title;
    protected String creator;
    protected int year;
    protected boolean checkedOut;

    public Media(){}

/*    public Media (String title, String creator, int year, boolean checkedOut){
        this.title = title;
        this.creator = creator;
        this.year = year;
        this.checkedOut = checkedOut;
    }*/

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

    public boolean getCheckedOut(){
        return checkedOut;
    }
}
