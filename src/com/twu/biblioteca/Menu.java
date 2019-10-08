package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public char displayAndChoseOption(){
        System.out.println("Choose a menu option(1, 2 or 3)");
        System.out.println("1. List of books");
        System.out.println("2. Return book");
        System.out.println("3. Quit application");
        Scanner scanner = new Scanner(System.in);

        int option = scanner.nextInt();
        switch(option) {
            case 1:
                return 'l';
            case 2:
                return 'r';
            case 3:
                return 'q';
            default:
                System.out.println("Please select a valid option!");
                return 'i';
        }
    }
}
