package com.smittrial.demo.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="book_lender")
public class SearchedBookLender {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private int userId;
    private int bookId;
    private int returned;
    private String firstname;
    private String lastname;
    private String bookname;
    private Date deadline;
    private int timeOverDeadlineInDays;

    public SearchedBookLender() {

    }
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getBookname() {
        return bookname;
    }

    public int getTimeOverDeadlineInDays() {
        return timeOverDeadlineInDays;
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

    public void setFirstname(String val) {
        firstname = val;
    }

    public void setLastname(String val) {
        lastname = val;
    }

    public void setBookname(String val) {
        bookname = val;
    }

    public void setTimeOverDeadlineInDays(int val) {
        timeOverDeadlineInDays = val;
    }
}
