package com.smittrial.demo.dao;


import com.smittrial.demo.models.BookLender;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookLendingsDAOWrapper {
    @Autowired
    private BookLendingsDAO dao;

    public List<BookLender>searchBookLender(String name){
        List<BookLender> list = new ArrayList<BookLender>();
        Iterable<BookLender> listEn = dao.searchBookLender("%"+name+"%");
        listEn.forEach(x->{
            BookLender item = new BookLender();
            BeanUtils.copyProperties(x, item);
            list.add(item);
        });
        return list;
    }
}