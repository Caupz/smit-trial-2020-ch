package com.smittrial.demo.models;

import com.smittrial.demo.enums.BookLendingDeadline;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BookModel {
    private int id;
    private String name;
    private String author;
    private String location;
    private Date published;
    private int quantity;
    private static String SHORT_LENDING_TIME = "1 week";
    private static String NORMAL_LENDING_TIME = "4 week";

    public static List<BookModel> getBooks() {
        List<BookModel> books = new ArrayList<BookModel>();
        books.add(new BookModel(
                1,
                "Implementation Patterns",
                "Kent Beck",
                "Programming Section 2th Cupboard on the left",
                StringToDate("2007-11-02 00:00:00"),
                5));
        return books;
    }

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
