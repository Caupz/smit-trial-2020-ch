package com.smittrial.demo.service;

import com.smittrial.demo.models.BookOvertimeResult;
import java.util.Collection;

public interface LateBookLendingsService {
    Collection<BookOvertimeResult> getAllLateBookLenders();
}
