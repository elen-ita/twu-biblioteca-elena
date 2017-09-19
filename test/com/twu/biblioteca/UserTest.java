package com.twu.biblioteca;

import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserTest {

    @Test
    public void testGetName(){
        User user = new User("Bob", "123-4567", "1234", "bob@gmail.com", "123-456-7890");
        assertEquals("Bob", user.getName());
    }

    @Test
    public void testGetUserID(){
        User user = new User("Bob", "123-4567", "1234", "bob@gmail.com", "123-456-7890");
        assertEquals("123-4567", user.getUserID());
    }

    @Test
    public void testGetPassword(){
        User user = new User("Bob", "123-4567", "1234", "bob@gmail.com", "123-456-7890");
        assertEquals("1234", user.getPassword());
    }

    @Test
    public void testGetEmail(){
        User user = new User("Bob", "123-4567", "1234", "bob@gmail.com", "123-456-7890");
        assertEquals("bob@gmail.com", user.getEmail());
    }

    @Test
    public void testGetPhone(){
        User user = new User("Bob", "123-4567", "1234", "bob@gmail.com", "123-456-7890");
        assertEquals("123-456-7890", user.getPhone());
    }

}
