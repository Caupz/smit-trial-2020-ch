package com.smittrial.demo.service;

import com.smittrial.demo.dao.UserDAOWrapper;
import com.smittrial.demo.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAOWrapper DAOWrapper;

    public Collection<UserModel> getAll(){
        return DAOWrapper.findAll();
    }

    public UserModel getById(int id){
        return DAOWrapper.findOne(id);
    }

    public Integer add(UserModel item){
        return DAOWrapper.save(item);
    }

    public UserModel update (UserModel item){
        return DAOWrapper.update(item);
    }

    public void remove (int id){
        DAOWrapper.delete(id);
    }
}