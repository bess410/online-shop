package com.epam.andrei_sterkhov.online_shop.dto;

import java.util.concurrent.atomic.AtomicInteger;

public class User{
    private static AtomicInteger count = new AtomicInteger();
    private int id;
    private String userName;
    private String surname;
    private String login;
    private String pass;

    public User() {
        this.id = count.incrementAndGet();
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
