package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    private String welcomeMessage;
    private Library l;
    Menu menu;

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Scanner scanner = new Scanner(System.in);

        System.out.println(bibliotecaApp.welcomeMessage);
        System.out.println("Choose a menu option(1, 2 or 3)");
        System.out.println("1. List of books");
        System.out.println("2. Return book");
        System.out.println("3. Quit application");

        while(scanner.hasNext()) {
            int option = scanner.nextInt();
            ArrayList<Book> res = bibliotecaApp.menu.choseOption(option);

            if (res != null) {
                System.out.println("Here you have the list of books of the library");

                for (Book r : res) {
                    String line = "";
                    line = line + r.title + " | " + r.author + " | " + r.year;
                    System.out.println(line);
                }
                System.out.println("\n");
                System.out.println("You want to checkout or return some of these books?");
                System.out.println("To checkout a book enter CheckOut and the title with a space between them. Example: CheckOut Lo que el viento se llevo");
                System.out.println("To return a book enter Return and the title with a space between them. Example: Return Lo que el viento se llevo");
                System.out.println("If you dont want to return or checkout a book press 0");

                String opt = scanner.next();
                String title = scanner.nextLine();

                if (opt.equals("CheckOut")) {
                    bibliotecaApp.menu.l.checkOutBook(title.trim());
                } else if (opt.equals("Return")) {
                    bibliotecaApp.menu.l.returnBook(title.trim());
                }
            }
            System.out.println("Choose a menu option writing the number:");
            System.out.println("1. List of books");
            System.out.println("2. Return book");
            System.out.println("3. Quit application");
        }
    }

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
