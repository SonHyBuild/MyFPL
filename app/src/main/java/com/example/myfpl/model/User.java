package com.example.myfpl.model;

public class User {
    private Integer idUser;
    private String email,password, fullName;

    public User(Integer idUser, String email, String password, String fullName) {
        this.idUser = idUser;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
