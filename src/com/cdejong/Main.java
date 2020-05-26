package com.cdejong;

public class Main {

    public static void main(String[] args) {

        UserController.createUser(new User("John", "Doe", "john.doe@example.com"));
        UserController.createUser(new User("Jane", "Doe", "jane.doe@example.com"));

	    UserController.getAllUsers().forEach(s -> System.out.println(s.getFirstname() + " " + s.getLastname()));
    }
}
