package com.cdejong;

public class User {
    private int userId;
    private String firstname;
    private String lastname;
    private String email;

    public User(int userId, String firstname, String lastname, String email) {
        this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public User(String firstname, String lastname, String email) {
        this.userId = 0;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
