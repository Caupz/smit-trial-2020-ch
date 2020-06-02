package com.smittrial.demo.dao;


import com.smittrial.demo.models.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOWrapper {
    @Autowired
    private UserDAO dao;

    public List<UserModel>findAll(){
        List<UserModel> list = new ArrayList<UserModel>();
        Iterable<UserModel> listEn= dao.findAll();
        listEn.forEach(x->{
            UserModel item = new UserModel();
            BeanUtils.copyProperties(x, item);
            list.add(item);
        });
        return list;
    }

    public UserModel findOne(Integer id){
        UserModel x= dao.findById(id).get();
        UserModel item = null;

        if(x!=null){
            item = new UserModel();
            BeanUtils.copyProperties(x, item);
        }
        System.out.println(x);
        return item;
    }

    public Integer save(UserModel product){
        UserModel item = new UserModel();
        BeanUtils.copyProperties(product, item);
        UserModel en=  dao.save(item);
        return en.getId();
    }

    public UserModel update(UserModel product){
        UserModel item = new UserModel();
        BeanUtils.copyProperties(product, item);
        UserModel en=  dao.save(item);
        UserModel product2 = new UserModel();
        BeanUtils.copyProperties(en,product2);
        return product2;
    }

    public void delete(int id){
        dao.deleteById(id);
    }
}