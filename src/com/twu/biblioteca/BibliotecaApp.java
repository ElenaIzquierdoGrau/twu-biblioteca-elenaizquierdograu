package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {
    private String welcomeMessage;
    private Library l;
    Menu menu;

    public BibliotecaApp() {
        this.welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        this.l = new Library();
        this.menu = new Menu();
    }

    String getWelcomeMessage() {
        return welcomeMessage;
    }

    public ArrayList<Book> getBooks(){
        System.out.println(welcomeMessage);
        return l.getBooks();
    }
}
