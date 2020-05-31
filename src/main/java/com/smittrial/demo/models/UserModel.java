package com.smittrial.demo.models;

public class UserModel {
    private int id;
    private String email;
    private String passwordHash;

    public UserModel(int _id) {
        id = _id;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
