package com.smittrial.demo.models;

import com.smittrial.demo.dao.BookLendingsDAO;

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
    private String firstname;
    private String lastname;
    private String bookname;
    private Date deadline;
    private int timeOverDeadlineInDays;

    public BookLender() {

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
