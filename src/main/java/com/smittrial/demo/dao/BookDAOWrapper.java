package com.smittrial.demo.dao;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.smittrial.demo.models.BookModel;

@Repository
public class BookDAOWrapper {
    @Autowired
    private BookDAO dao;

    public List<BookModel>findAll(){
        List<BookModel> list = new ArrayList<BookModel>();
        Iterable<BookModel> listEn= dao.findAll();
        listEn.forEach(x->{
            BookModel book = new BookModel();
            BeanUtils.copyProperties(x, book);
            list.add(book);
        });
        return list;
    }

    public BookModel findOne(Integer id){
        BookModel x= dao.findById(id).get();
        BookModel book = null;

        if(x!=null){
            book = new BookModel();
            BeanUtils.copyProperties(x, book);
        }
        System.out.println(x);
        return book;
    }

    public BookModel findByName(String name){
        BookModel x= dao.findByNameContaining(name);
        BookModel book = null;

        if(x!=null){
            book = new BookModel();
            BeanUtils.copyProperties(x, book);
        }
        System.out.println(x);
        return book;
    }

    public Integer saveProduct(BookModel product){
        BookModel productEntityBean = new BookModel();
        BeanUtils.copyProperties(product, productEntityBean);
        BookModel en=  dao.save(productEntityBean);
        return en.getId();
    }

    public BookModel updateProduct(BookModel product){
        BookModel productEntityBean = new BookModel();
        BeanUtils.copyProperties(product, productEntityBean);
        BookModel en=  dao.save(productEntityBean);
        BookModel product2 = new BookModel();
        BeanUtils.copyProperties(en,product2);
        return product2;
    }

    public void delete(int id){
        dao.deleteById(id);
    }
}