package com.twu.biblioteca;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.BibliotecaApp;

import java.util.ArrayList;

public class Library {

    public static ArrayList<Book> books = new ArrayList<Book>()
    {{
        add(new Book("The Great Gatsby","F. Scott Fitzgerald", 1925, false));
        add(new Book("The Grapes of Wrath", "John Steinbeck", 1939, false));
        add(new Book("Nineteen Eighty-Four","George Orwell", 1949, false));
        add(new Book("Ulysses", "James Joyce", 1918, false));
        add(new Book("Lolita", "Vladimir Nabakov", 1955, false));
        add(new Book("Catch-22", "Joseph Heller", 1961, false));
        add(new Book("The Catcher in the Rye", "J.D. Salinger", 1951, false));
        add(new Book("Beloved", "Toni Morrison", 1987, false));
        add(new Book("To Kill a Mockingbird", "Harper Lee", 1960, false));
        add(new Book("One Hundred Years of Solitude", "J. R. R. Tolkien", 1954, false));
    }};

    public static void printBookList() {
        System.out.printf("%-35s%-25s%-4s\n", "Title", "Author", "Year");
        System.out.println("----------------------------------------------------------------");
        for (Book book : books){
            if(!book.getCheckedOut()){
                System.out.printf("%-35s%-25s%-4s\n", book.getTitle(), book.getAuthor(), book.getDatePublished());
            }
        }
        System.out.println("----------------------------------------------------------------");
    }

    public static boolean checkOutBook(String userChoice) {
        for(Book book : books){
            if(book.getTitle().equals(userChoice) && !book.getCheckedOut()) {
                book.setCheckedOut(true);
                return true;
            }
        }
        return false;
    }

    public static boolean returnBook(String userChoice){
        for(Book book : books){
            if(book.getTitle().equals(userChoice) && book.getCheckedOut()){
                book.setCheckedOut(false);
                return true;
            }
        }
        return false;
    }

}


