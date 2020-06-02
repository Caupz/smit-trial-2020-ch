package com.smittrial.demo.dao;

import com.smittrial.demo.models.BookLender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookLendingsDAO extends JpaRepository<BookLender, Long> {

    @Query(value = "SELECT bl.id, bl.user_id, bl.book_id, bl.deadline, u.firstname, u.lastname, b.name AS bookname, DATEDIFF(NOW(), bl.deadline) AS time_over_deadline_in_days FROM `user` AS u LEFT JOIN book_lender AS bl ON u.id = bl.user_id LEFT JOIN book AS b ON bl.book_id = b.id WHERE u.firstname LIKE :name OR u.lastname LIKE :name OR CONCAT(CONCAT(u.firstname, \" \"), u.lastname) LIKE :name", nativeQuery = true)
    List<BookLender> searchBookLender(@Param("name") String name);
}
