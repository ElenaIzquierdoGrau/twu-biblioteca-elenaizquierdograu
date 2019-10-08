package com.twu.biblioteca;

import java.util.ArrayList;

public class Menu {
    ArrayList<String> options;
    Library l;

    public Menu(){
        options = new ArrayList<String>();
        options.add("List of books");
        l = new Library();
    }

    public ArrayList<Book> choseOption(String option) throws InvalidMenuOptionException{
        if(option == "List of books"){
            return l.getBooks();
        }
        throw new InvalidMenuOptionException("Invalid option menu: "+option);
    }
}
