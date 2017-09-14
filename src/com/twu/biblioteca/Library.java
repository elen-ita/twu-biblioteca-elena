package com.twu.biblioteca;


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

    public static ArrayList<Movie> movies = new ArrayList<Movie>()
    {{
        add(new Movie("The Wizard of Oz", "King Vidor", 1939, 9.4, false));
        add(new Movie("Jaws", "Stephen Spielberg", 1975, 9.2,  false));
    }};

    public static void printBookList() {
        System.out.printf("%-35s%-25s%-4s\n", "Title", "Author", "Year");
        System.out.println("----------------------------------------------------------------");
        for (Book book : books){
            if(!book.getCheckedOut()){
                System.out.printf("%-35s%-25s%-4s\n", book.getTitle(), book.getCreator(), book.getYear());
            }
        }
        System.out.println("----------------------------------------------------------------");
    }

    public static void printMovieList() {
        System.out.printf("%-35s%-25s%-10s%-6s\n", "Title", "Director", "Year", "Rating");
        System.out.println("----------------------------------------------------------------------------");
        for (Movie movie : movies){
            if(!movie.getCheckedOut()){
                System.out.printf("%-35s%-25s%-10s%6s\n", movie.getTitle(), movie.getCreator(), movie.getYear(), movie.getRating());
            }
        }
        System.out.println("----------------------------------------------------------------------------");
    }



    public static String returnBook(String userChoice){
        Book selectedBook = findBook(userChoice);
        if(selectedBook != null && selectedBook.getCheckedOut()){
            selectedBook.setCheckedOut(false);
            return "Thank you for returning the book";
        } else {
            return "That is not a valid book return";
        }
    }

    public static String checkOutBook(String userChoice){
        Book selectedBook = findBook(userChoice);
        if(selectedBook != null && !selectedBook.getCheckedOut()){
            selectedBook.setCheckedOut(true);
            return "Thank you! Enjoy the book";
        } else {
            return "That book is not available";
        }
    }

    public static Book findBook(String userChoice){
        for(Book book : books){
            if (book.getTitle().equals(userChoice)){
                return book;
            }
        }
        return null;
    }
}


