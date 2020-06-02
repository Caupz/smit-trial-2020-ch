package com.smittrial.demo.dao;

import com.smittrial.demo.models.SearchedBookLender;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SearchBookLendingsDAOWrapper {
    @Autowired
    private SearchBookLendingsDAO dao;

    public List<SearchedBookLender>searchBookLender(String name){
        List<SearchedBookLender> list = new ArrayList<SearchedBookLender>();
        Iterable<SearchedBookLender> listEn = dao.searchBookLender("%"+name+"%");
        listEn.forEach(x->{
            SearchedBookLender item = new SearchedBookLender();
            BeanUtils.copyProperties(x, item);
            list.add(item);
        });
        return list;
    }
}