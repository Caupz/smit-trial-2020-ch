package com.smittrial.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.smittrial.demo.models.BookModel;

public interface BookDAO extends JpaRepository<BookModel, Integer> {

    BookModel findByNameContaining(String name);
}
