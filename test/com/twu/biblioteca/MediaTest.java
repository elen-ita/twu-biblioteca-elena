package com.twu.biblioteca;

import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MediaTest {

    @Test
    public void testGetTitle(){
        Media jaws = new Media("Jaws", "Stephen Spielberg", 1975, 9.2, "Movie",  null);
        assertEquals("Jaws", jaws.getTitle());
    }

    @Test
    public void testGetCreator(){
        Media jaws = new Media("Jaws", "Stephen Spielberg", 1975, 9.2, "Movie",  null);
        assertEquals("Stephen Spielberg", jaws.getCreator());
    }

    @Test
    public void testGetYear(){
        Media jaws = new Media("Jaws", "Stephen Spielberg", 1975, 9.2, "Movie",  null);
        assertEquals(1975, jaws.getYear());
    }

    @Test
    public void testGetRating(){
        Media jaws = new Media("Jaws", "Stephen Spielberg", 1975, 9.2, "Movie",  null);
        assertTrue(Math.abs(9.2 - jaws.getRating()) < .01);
    }

    @Test
    public void testGetMediaType(){
        Media jaws = new Media("Jaws", "Stephen Spielberg", 1975, 9.2, "Movie",  null);
        assertEquals("Movie", jaws.getMediaType());
    }

    @Test
    public void testGetCheckedOutTo(){
        Media jaws = new Media("Jaws", "Stephen Spielberg", 1975, 9.2, "Movie",  null);
        assertEquals(null, jaws.getCheckedOutTo());
    }

    @Test
    public void testSetCheckedOutTo(){
        Media jaws = new Media("Jaws", "Stephen Spielberg", 1975, 9.2, "Movie",  null);
        jaws.setCheckedOutTo("123-4567");
        assertEquals("123-4567", jaws.getCheckedOutTo());
    }

}
