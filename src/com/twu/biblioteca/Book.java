package com.twu.biblioteca;

public class Book {
    private String title;
    private Integer year;
    private String author;
    private Boolean checkedOut;
    private String libraryNumber;

    public Book(String title, Integer year, String author){
        this.title = title;
        this.year = year;
        this.author = author;
        this.checkedOut = false;
    }

    public void checkOut(String libraryNumber) {
        if(!checkedOut){
            System.out.println("Thank you! Enjoy the book");
            this.libraryNumber = libraryNumber;
            checkedOut = true;
        }
        else{
            System.out.println("Sorry, that book is not available");
        }
    }

    public void returnBook() {
        if(checkedOut){
            checkedOut = false;
            this.libraryNumber = null;
            System.out.println("Thank you for returning the book");
        }
        else{
            System.out.println("That is not a valid book to return");
        }
    }

    public Boolean getCheckedOut() {
        return checkedOut;
    }
    public String getLibraryNumberFromUser() {
        return libraryNumber;
    }


    public String getAuthor() {
        return author;
    }

    public Integer getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public void setCheckedOut(Boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

}
