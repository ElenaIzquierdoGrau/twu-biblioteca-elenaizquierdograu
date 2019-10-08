package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Library l;

    public Menu(){
        l = new Library();
    }

    public ArrayList<Book> choseOption(Integer option){
        Scanner scanner = new Scanner(System.in);
        switch(option) {
            case 1:
                return l.getAvailableBooks();
            case 2:
                System.out.println("Write the title of the book you want to return");
                String title = scanner.nextLine();
                l.returnBook(title);
                return null;
            case 3:
                System.exit(0);
            default:
                System.out.println("Please select a valid option!");
                return null;
        }
    }
}
