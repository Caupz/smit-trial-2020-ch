package com.smittrial.demo.dao;

import com.smittrial.demo.models.BookLender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookLendingsDAO extends JpaRepository<BookLender, Integer> {

    BookLender findByBookIdAndUserId(Integer bookId, Integer userId);

    @Query(value = "SELECT count(*) FROM book_lender WHERE returned = 0 AND book_id = :bookId", nativeQuery = true)
    Integer getCountOfLendedBook(@Param("bookId") Integer bookId);
}
