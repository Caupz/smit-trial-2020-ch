package com.smittrial.demo.service;

import com.smittrial.demo.dao.RoleDAOWrapper;
import com.smittrial.demo.models.BookModel;
import com.smittrial.demo.models.RoleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDAOWrapper DAOWrapper;

    public Collection<RoleModel> getAll(){
        return DAOWrapper.findAll();
    }

    public RoleModel getById(int id){
        return DAOWrapper.findOne(id);
    }

    public Integer add(RoleModel item){
        return DAOWrapper.save(item);
    }

    public RoleModel update (RoleModel item){
        return DAOWrapper.update(item);
    }

    public void remove (int id){
        DAOWrapper.delete(id);
    }

    public Collection<RoleModel> getUserRoles(int userId){
        return DAOWrapper.findAllByUserId(userId);
    }
}