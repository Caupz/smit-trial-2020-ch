package com.smittrial.demo.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smittrial.demo.models.BookModel;
import com.smittrial.demo.dao.BookDAOWrapper;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDAOWrapper DAOWrapper;

    public Collection<BookModel> getAllBooks(){
        return DAOWrapper.findAll();
    }

    public BookModel getBookById(int id){
        return DAOWrapper.findOne(id);
    }

    public BookModel getBookByNameContaining(String name){
        return DAOWrapper.findByName(name);
    }

    public Integer addBook(BookModel product){
        return DAOWrapper.saveProduct(product);
    }

    public BookModel updateBook (BookModel product){
        return DAOWrapper.updateProduct(product);
    }

    public void removeBook (int id){
        DAOWrapper.delete(id);
    }
}