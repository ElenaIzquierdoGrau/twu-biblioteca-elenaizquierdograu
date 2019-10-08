package com.twu.biblioteca;

import java.util.ArrayList;

public class Menu {
    private ArrayList<String> options;
    Library l;

    public Menu(){
        options = new ArrayList<String>();
        options.add("List of books");
        options.add("Quit");
        l = new Library();
    }

    public ArrayList<Book> choseOption(String option) throws InvalidMenuOptionException{
        if(option.equals("List of books")){
            return l.getAvailableBooks();
        }
        else if(option.equals("Quit")){
            return null;
        }
        throw new InvalidMenuOptionException("Please select a valid option!");
    }
}
