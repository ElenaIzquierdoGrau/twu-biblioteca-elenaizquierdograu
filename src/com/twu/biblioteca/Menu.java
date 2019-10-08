package com.twu.biblioteca;

import java.util.ArrayList;

public class Menu {
    ArrayList<String> options;
    Library l;

    public Menu(){
        options = new ArrayList<String>();
        options.add("List of books");
        options.add("Quit");
        l = new Library();
    }

    public ArrayList<Book> choseOption(String option) throws InvalidMenuOptionException{
        if(option == "List of books"){
            return l.getBooks();
        }
        else if(option == "Quit"){
            return null;
        }
        throw new InvalidMenuOptionException("Please select a valid option!");
    }
}
