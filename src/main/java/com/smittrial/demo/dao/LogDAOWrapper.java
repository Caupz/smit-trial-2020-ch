package com.smittrial.demo.dao;


import com.smittrial.demo.models.LogModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LogDAOWrapper {
    @Autowired
    private LogDAO dao;

    public Integer save(LogModel _item){
        LogModel item = new LogModel();
        BeanUtils.copyProperties(_item, item);
        LogModel en = dao.save(item);
        return en.getId();
    }
}