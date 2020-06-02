package com.smittrial.demo.dao;


import com.smittrial.demo.models.BookLender;
import com.smittrial.demo.models.BookOvertimeResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookLendingsDAOWrapper {
    @Autowired
    private BookLendingsDAO dao;

    public List<BookOvertimeResult>getLateBookLenders(){
        List<BookOvertimeResult> list = new ArrayList<BookOvertimeResult>();
        Iterable<BookOvertimeResult> listEn = dao.getLateBookLenders();
        listEn.forEach(x->{
            BookOvertimeResult item = new BookOvertimeResult();
            BeanUtils.copyProperties(x, item);
            list.add(item);
        });
        return list;
    }
}