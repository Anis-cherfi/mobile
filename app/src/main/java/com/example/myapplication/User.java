package com.example.myapplication;

public class User {
    private String username;
    private String pwd;
    private String cin;
    private String firstname, lastname;


    public User(String username, String pwd, String cin, String firstname, String lastname) {
        this.username = username;
        this.pwd = pwd;
        this.cin = cin;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
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
}

