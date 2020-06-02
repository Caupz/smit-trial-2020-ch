package com.smittrial.demo.dao;

import com.smittrial.demo.models.BookLender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookLendingsDAO extends JpaRepository<BookLender, Integer> {

    BookLender findByBookIdAndUserId(Integer bookId, Integer userId);
}
