package com.smittrial.demo.dao;

import com.smittrial.demo.models.BookOvertimeResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookLendingsDAO extends JpaRepository<BookOvertimeResult, Long> {

    @Query(value = "SELECT bl.id, u.firstname, u.lastname, b.name AS bookname, DATEDIFF(NOW(), bl.deadline) AS time_over_deadline_in_days FROM `user` AS u LEFT JOIN book_lender AS bl ON u.id = bl.user_id LEFT JOIN book AS b ON bl.book_id = b.id WHERE bl.deadline <= NOW()", nativeQuery = true)
    List<BookOvertimeResult> getLateBookLenders();
}
