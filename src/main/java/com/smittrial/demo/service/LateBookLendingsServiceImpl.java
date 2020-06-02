package com.smittrial.demo.service;

import java.util.Collection;
import java.util.List;

import com.smittrial.demo.models.BookOvertimeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smittrial.demo.dao.BookLendingsDAOWrapper;

@Service
public class LateBookLendingsServiceImpl implements LateBookLendingsService {
    @Autowired
    private BookLendingsDAOWrapper DAOWrapper;

    public Collection<BookOvertimeResult> getAllLateBookLenders(){
        return DAOWrapper.getLateBookLenders();
    }
}
