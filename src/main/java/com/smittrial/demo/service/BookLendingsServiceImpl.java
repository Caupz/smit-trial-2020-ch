package com.smittrial.demo.service;

import java.util.Collection;

import com.smittrial.demo.dao.LateBookLendingsDAOWrapper;
import com.smittrial.demo.dao.SearchBookLendingsDAOWrapper;
import com.smittrial.demo.models.BookLender;
import com.smittrial.demo.models.BookOvertimeResult;
import com.smittrial.demo.models.SearchedBookLender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smittrial.demo.dao.BookLendingsDAOWrapper;

@Service
public class BookLendingsServiceImpl implements LateBookLendingsService {
    @Autowired
    private BookLendingsDAOWrapper DAOWrapper;
    @Autowired
    private SearchBookLendingsDAOWrapper searchDAOWrapper;
    @Autowired
    private LateBookLendingsDAOWrapper LateDAOWrapper;

    public Collection<BookOvertimeResult> getAllLateBookLenders(){
        return LateDAOWrapper.getLateBookLenders();
    }
    public Collection<SearchedBookLender> searchBookLender(String name){
        return searchDAOWrapper.searchBookLender(name);
    }
    public BookLender findByBookAndUserId(Integer bookId, Integer userId){
        return DAOWrapper.findByBookAndUserId(bookId, userId);
    }
    public void update(BookLender lender) {
        DAOWrapper.update(lender);
    }
}
