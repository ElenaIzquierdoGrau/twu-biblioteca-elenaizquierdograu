package com.twu.biblioteca;
import java.util.ArrayList;

public class Library {
    ArrayList<Book> books;
    ArrayList<Movie> movies;

    public Library() {
        books = new ArrayList<Book>();
        Book a = new Book("Lo que el viento se llevo",1997,"Elena Izquierdo");
        Book b = new Book("La sombra del viento",2017,"Elena Grau");
        this.books.add(a);
        this.books.add(b);

        movies = new ArrayList<Movie>();
        Movie mb = new Movie("Malditos bastardos", 2008, "Quentin Tarantino",10);
        Movie pit = new Movie("Los pitufos",2015,"Carmen Machi", -1);
        this.movies.add(mb);
        this.movies.add(pit);
    }

    public void printAllBooks() {
        System.out.println("Here you have the list of all the books in the library");
        String first_line = "|      Title            |       Author      |   Year  |";
        System.out.println(first_line);
        for (Book b : books) {
            String line = "";
            line = line + b.title + " | " + b.author + " | " + b.year;
            System.out.println(line);
        }
    }

    public void listAvailableBooks(){
        ArrayList<Book> availableBooks = new ArrayList<Book>();
        for (Book book : books) {
            if (!book.checkedOut) {
                availableBooks.add(book);
            }
        }
        System.out.println("Here you have the list of available books of the library");
        String first_line = "|      Title            |       Author      |   Year  |";
        System.out.println(first_line);
        for (Book ab : availableBooks) {
            String line = "";
            line = line + ab.title + " | " + ab.author + " | " + ab.year;
            System.out.println(line);
        }
    }

    public void checkOutBook(String title){
        Book b = getBook(title);
        if(b != null) b.checkOut("111-1111");
        else System.out.println("Sorry, that book is not available");
    }
    public void returnBook(String title){
        Book b = getBook(title);
        if(b != null) b.returnBook();
        else System.out.println("That is not a valid book to return");
    }

    public Book getBook(String title){
        for (Book book : books) {
            if (book.title.equals(title)) {
                return book;
            }
        }
        return null;
    }

    public void listAvailableMovies() {
        ArrayList<Movie> availableMovies = new ArrayList<Movie>();
        for (Movie movie : movies) {
            if (!movie.getCheckedout()) {
                availableMovies.add(movie);
            }
        }
        System.out.println("Here you have the list of available movies of the library");
        String first_line = ("|      Name            |       Year      |   Director  |   Rate  |");
        System.out.println(first_line);
        for (Movie am : availableMovies) {
            String line = "";
            String rate;
            if(am.getRating() == -1) rate = "No rating";
            else rate = am.getRating().toString();

            line = line + am.getName() + " | " + am.getYear() + " | " + am.getDirector() + " | " + rate;
            System.out.println(line);
        }
    }

    public Movie getMovie(String name) {
        for (Movie movie : movies) {
            if (movie.getName().equals(name)) {
                return movie;
            }
        }
        return null;
    }

    public void checkOutMovie(String name) {
        Movie m = getMovie(name);
        if(m == null) System.out.println("Sorry, that movie is not available");
        else m.checkOut();
    }
}
