package com.smittrial.demo.models;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="book_lender")
public class BookOvertimeResult {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    private String bookname;
    private int timeOverDeadlineInDays;

    public BookOvertimeResult() {

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

    public void set(int val) {
        timeOverDeadlineInDays = val;
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
