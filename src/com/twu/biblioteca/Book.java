package com.twu.biblioteca;

public class Book {
    String title;
    Integer year;
    String author;
    Boolean checkedOut;

    public Book(String title, Integer year, String author){
        this.title = title;
        this.year = year;
        this.author = author;
        this.checkedOut = false;
    }

    public void checkOut() {
        if(!checkedOut){
            System.out.println("Thank you! Enjoy the book");
            checkedOut = true;
        }
        else{
            System.out.println("Sorry, that book is not available");
        }
    }

    public void returnBook() {
        if(checkedOut){
            checkedOut = false;
            System.out.println("Thank you for returning the book");
        }
        else{
            System.out.println("That is not a valid book to return");
        }
    }

    public Boolean getCheckedOut() {
        return checkedOut;
    }
    public void setCheckedOut(Boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
}
