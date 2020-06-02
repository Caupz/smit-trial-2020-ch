package com.smittrial.demo.models;

import com.smittrial.demo.enums.BookLendingDeadline;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name="log")
public class LogModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private int userId;
    private String description;

    public LogModel() {

    }
    public LogModel(int _userId, String _description) {
        userId = _userId;
        description = _description;
    }

    public void setId(int val) {
        id = val;
    }
    public void setUserId(int val) {
        userId = val;
    }
    public void setDescription(String val) {
        description = val;
    }

    public int getId() {
        return id;
    }
    public int getUserId() {
        return userId;
    }
    public String getDescription() {
        return description;
    }
}
