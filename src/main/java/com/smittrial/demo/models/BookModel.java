package com.smittrial.demo.models;

public class BookModel {
    private int id;
    private String name;
    private String author;
    private int year;
    private int quantity;

    public BookModel(int _id) {
        id = _id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public int getQuantity() {
        return quantity;
    }
}
