package com.smittrial.demo.service;

import java.util.Collection;

import com.smittrial.demo.dao.LateBookLendingsDAOWrapper;
import com.smittrial.demo.models.BookLender;
import com.smittrial.demo.models.BookOvertimeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smittrial.demo.dao.BookLendingsDAOWrapper;

@Service
public class BookLendingsServiceImpl implements LateBookLendingsService {
    @Autowired
    private BookLendingsDAOWrapper DAOWrapper;
    @Autowired
    private LateBookLendingsDAOWrapper LateDAOWrapper;

    public Collection<BookOvertimeResult> getAllLateBookLenders(){
        return LateDAOWrapper.getLateBookLenders();
    }
    public Collection<BookLender> searchBookLender(String name){
        return DAOWrapper.searchBookLender(name);
    }
}
