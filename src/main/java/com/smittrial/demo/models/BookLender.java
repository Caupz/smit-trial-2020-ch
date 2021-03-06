package com.smittrial.demo.models;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

@Entity
@Table(name="book_lender")
public class BookLender {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private int userId;
    private int bookId;
    private int returned;
    private Date deadline;

    public BookLender() {

    }

    public int getId() {
        return id;
    }
    public int getReturned() {
        return returned;
    }

    public int getUserId() {
        return userId;
    }

    public int getBookId() {
        return bookId;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setId(int val) {
        id = val;
    }

    public void setUserId(int val) {
        userId = val;
    }
    public void setReturned(int val) {
        returned = val;
    }

    public void setBookId(int val) {
        bookId = val;
    }

    public void setDeadline(Date val) {
        deadline = val;
    }
}
