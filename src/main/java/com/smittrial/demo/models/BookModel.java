package com.smittrial.demo.models;

import com.smittrial.demo.enums.BookLendingDeadline;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="book")
public class BookModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    private String author;
    private String location;
    private Date published;
    private int quantity;
    private static String SHORT_LENDING_TIME = "1 week";
    private static String NORMAL_LENDING_TIME = "4 week";

    public static Date StringToDate(String dateStr){
        Date result = null;
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            result  = dateFormat.parse(dateStr);
        }

        catch(ParseException e){
            e.printStackTrace();

        }
        return result ;
    }

    public BookModel() {

    }

    public BookModel(int _id, String _name, String _author, String _location, Date _published, int _quantity) {
        id = _id;
        name = _name;
        author = _author;
        location = _location;
        published = _published;
        quantity = _quantity;
    }

    public String toString() {
        return String.format("Name: %s Author: %s Quantity: %d Lending time: %s Location: %s",
                getName(), getAuthor(), getQuantityAvailable(), getLendingTime(), getLocation());
    }

    public void setId(int val) {
        id = val;
    }
    public void setName(String val) {
        name = val;
    }
    public void setAuthor(String val) {
        author = val;
    }
    public void setLocation(String val) {
        location = val;
    }
    public void setPublished(Date val) {
        published = val;
    }
    public void setQuantity(int val) {
        quantity = val;
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

    public String getLocation() {
        return location;
    }

    public Date getPublished() {
        return published;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getQuantityAvailable() {
        return quantity; // TODO
    }

    public Date getDate3MonthsBefore() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -3);
        Date date = cal.getTime();
        return date;
    }

    public boolean IsBookNew() {
        return (getPublished().before(getDate3MonthsBefore()));
    }

    public String getLendingTime() {
        if(getLendingPeriod() == BookLendingDeadline.SHORT) {
            return SHORT_LENDING_TIME;
        }

        return NORMAL_LENDING_TIME;
    }

    private BookLendingDeadline getLendingPeriod() {
        if(getQuantity() < 5 || IsBookNew()) {
            return BookLendingDeadline.SHORT;
        }

        return BookLendingDeadline.NORMAL;
    }
}
