package com.smittrial.demo.service;

import java.util.Collection;
import com.smittrial.demo.models.BookModel;

public interface BookService {
    Collection<BookModel> getAllBooks();
    BookModel getBookById(int id);
    BookModel getBookByNameContaining(String name);
    Integer addBook(BookModel product);
    BookModel updateBook(BookModel product);
    void removeBook(int id);
}
