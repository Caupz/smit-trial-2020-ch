package com.smittrial.demo.dao;


import com.smittrial.demo.models.BookLender;
import com.smittrial.demo.models.SearchedBookLender;
import com.smittrial.demo.models.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookLendingsDAOWrapper {
    @Autowired
    private BookLendingsDAO dao;

    public BookLender findByBookAndUserId(Integer bookId, Integer userId){
        BookLender x= dao.findByBookIdAndUserId(bookId, userId);
        BookLender item = null;

        if(x!=null){
            item = new BookLender();
            BeanUtils.copyProperties(x, item);
        }
        System.out.println(x);
        return item;
    }

    public Integer getCountOfLendedBook(Integer bookId) {
        return dao.getCountOfLendedBook(bookId);
    }

    public BookLender update(BookLender model){
        BookLender item = new BookLender();
        BeanUtils.copyProperties(model, item);
        BookLender en = dao.save(item);
        BookLender item2 = new BookLender();
        BeanUtils.copyProperties(en,item2);
        return item2;
    }
    public Integer save(BookLender model){
        BookLender item = new BookLender();
        BeanUtils.copyProperties(model, item);
        BookLender en = dao.save(item);
        return en.getId();
    }
}