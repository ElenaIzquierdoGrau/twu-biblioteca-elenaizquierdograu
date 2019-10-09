package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {
    private String welcomeMessage;
    private Library l;
    Menu menu;

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        Scanner scanner = new Scanner(System.in);

        bibliotecaApp.printAllBooks();

        char option = bibliotecaApp.menu.displayAndChoseOption();
        while(option != 'q') {
            if(option == 'l'){
                bibliotecaApp.l.listAvailableBooks();

                System.out.println("\n");
                System.out.println("You want to checkout some of these books?");
                System.out.println("To checkout a book enter Checkout and the title with a space between them. Example: Checkout Lo que el viento se llevo");
                System.out.println("If you dont want to checkout a book press 0");

                String opt = scanner.next();
                String title = scanner.nextLine();

                if (opt.equals("Checkout")) {
                    System.out.println("In order to checkout a book you must Log In with your credentials");
                    System.out.println("To Login you must write your library number");
                    String libraryNumber = scanner.nextLine();
                    System.out.println("Write your password");
                    String password = scanner.nextLine();

                    AuthenticationService authenticationService = new AuthenticationService();

                    if(authenticationService.login(libraryNumber,password)) bibliotecaApp.l.checkOutBook(title.trim(), authenticationService);
                }
            }

            else if(option == 'm'){
                bibliotecaApp.l.listAvailableMovies();

                System.out.println("\n");
                System.out.println("You want to checkout some of these movies?");
                System.out.println("To checkout a movie enter Checkout and the title with a space between them. Example: Checkout Malditos bastardos");
                System.out.println("If you dont want to checkout a movie press 0");

                String opt = scanner.next();
                String title = scanner.nextLine();

                if (opt.equals("Checkout")) {
                    bibliotecaApp.l.checkOutMovie(title.trim());
                }
            }

            else if(option == 'r'){
                System.out.println("In order to return a book you must Log In with your credentials");
                System.out.println("To Login you must write your library number");

                String libraryNumber = scanner.nextLine();
                System.out.println("Write your password");
                String password = scanner.nextLine();

                AuthenticationService authenticationService = new AuthenticationService();

                if(authenticationService.login(libraryNumber,password)){
                    System.out.println("Write the title of the book you want to return");
                    String title = scanner.nextLine();
                    bibliotecaApp.l.returnBook(title);
                }
            }

            else if(option == 'b'){
                bibliotecaApp.l.printAllBooks();
            }

            else if(option == 'p'){
                System.out.println("To be able to view your information you must log in");
                System.out.println("To Login you must write your library number");

                String libraryNumber = scanner.nextLine();
                System.out.println("Write your password");
                String password = scanner.nextLine();

                AuthenticationService authenticationService = new AuthenticationService();

                if(authenticationService.login(libraryNumber,password)){
                    authenticationService.currentUser.displayProfileInformation();
                }
            }
            option = bibliotecaApp.menu.displayAndChoseOption();
        }
        System.out.println("Good bye! See you soon!");
    }

    public BibliotecaApp() {
        this.welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        this.l = new Library();
        this.menu = new Menu();
    }

    String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void printAllBooks(){
        System.out.println(welcomeMessage);
        l.printAllBooks();
    }
}
