package com.smittrial.demo.service;

import com.smittrial.demo.models.BookLender;
import com.smittrial.demo.models.BookOvertimeResult;
import com.smittrial.demo.models.SearchedBookLender;

import java.util.Collection;

public interface LateBookLendingsService {
    Collection<BookOvertimeResult> getAllLateBookLenders();
    Collection<SearchedBookLender> searchBookLender(String name);
}
