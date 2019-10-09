package com.twu.biblioteca;

import java.util.Scanner;

public class Menu {

    public char displayAndChoseOption(){
        System.out.println("Choose a menu option(1, 2, 3, 4, 5 or 6)");
        System.out.println("1. List of books");
        System.out.println("2. Return book");
        System.out.println("3. List of movies");
        System.out.println("4. List of all books including checkout users information");
        System.out.println("5. View profile");
        System.out.println("6. Quit application");
        Scanner scanner = new Scanner(System.in);

        int option = scanner.nextInt();
        switch(option) {
            case 1:
                return 'l';
            case 2:
                return 'r';
            case 3:
                return 'm';
            case 4:
                return 'b';
            case 5:
                return 'p';
            case 6:
                return 'q';
            default:
                System.out.println("Please select a valid option!");
                return 'i';
        }
    }
}
