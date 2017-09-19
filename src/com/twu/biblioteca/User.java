package com.twu.biblioteca;

public class User {

    protected String name;
    protected String userID;
    protected String password;
    protected String email;
    protected String phone;

    public User(String name, String userID, String password, String email, String phone){
        this.name = name;
        this.userID = userID;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public String getName(){
        return name;
    }

    public String getUserID(){
        return userID;
    }

    public String getPassword(){
        return password;
    }

    public String getEmail(){
        return email;
    }

    public String getPhone(){
        return phone;
    }

}
