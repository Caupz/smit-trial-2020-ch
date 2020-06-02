package com.smittrial.demo.dao;


import com.smittrial.demo.models.RoleModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RoleDAOWrapper {
    @Autowired
    private RoleDAO dao;

    public List<RoleModel>findAll(){
        List<RoleModel> list = new ArrayList<RoleModel>();
        Iterable<RoleModel> listEn= dao.findAll();
        listEn.forEach(x->{
            RoleModel item = new RoleModel();
            BeanUtils.copyProperties(x, item);
            list.add(item);
        });
        return list;
    }

    public List<RoleModel>findAllByUserId(int userId){
        List<RoleModel> list = new ArrayList<RoleModel>();
        Iterable<RoleModel> listEn= dao.getUserRoles(userId);
        listEn.forEach(x->{
            RoleModel item = new RoleModel();
            BeanUtils.copyProperties(x, item);
            list.add(item);
        });
        return list;
    }

    public RoleModel findOne(Integer id){
        RoleModel x= dao.findById(id).get();
        RoleModel item = null;

        if(x!=null){
            item = new RoleModel();
            BeanUtils.copyProperties(x, item);
        }
        System.out.println(x);
        return item;
    }

    public Integer save(RoleModel product){
        RoleModel item = new RoleModel();
        BeanUtils.copyProperties(product, item);
        RoleModel en=  dao.save(item);
        return en.getId();
    }

    public RoleModel update(RoleModel product){
        RoleModel item = new RoleModel();
        BeanUtils.copyProperties(product, item);
        RoleModel en=  dao.save(item);
        RoleModel product2 = new RoleModel();
        BeanUtils.copyProperties(en,product2);
        return product2;
    }

    public void delete(int id){
        dao.deleteById(id);
    }
}