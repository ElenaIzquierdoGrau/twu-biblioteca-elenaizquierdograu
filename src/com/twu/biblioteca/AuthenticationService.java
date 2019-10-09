package com.twu.biblioteca;

import java.util.ArrayList;

public class AuthenticationService {
    private ArrayList<User> users;
    public User currentUser;

    public AuthenticationService(){
        users = new ArrayList<User>();
        User u1 = new User("111-1111","1234","Elena","elena.izquierdo@email.com","612345678");
        User u2 = new User("222-2222","1234","Maria","maria.izquierdo@email.com","612225678");
        users.add(u1);
        users.add(u2);
        currentUser = null;
    }

    public User getUser(String libraryNumber){
        for(User user: users){
            if(user.getLibraryNumber().equals(libraryNumber)){
                return user;
            }
        }
        return null;
    }

    public void login(String libraryNumber, String password) {
        User foundUser = getUser(libraryNumber);
        if(foundUser != null){
            if(foundUser.getPassword().equals(password)){
                currentUser = foundUser;
                System.out.println("LogIn successful. Welcome to Biblioteca!");
            }
            else{
                System.out.println("LogIn not successful. Wrong password.");
            }
        }
        else{
            System.out.println("LogIn not successful. User not found.");
        }

    }
}
