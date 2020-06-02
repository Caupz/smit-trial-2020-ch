package com.smittrial.demo.service;

import com.smittrial.demo.dao.LogDAOWrapper;
import com.smittrial.demo.models.LogModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDAOWrapper DAOWrapper;

    public Integer add(LogModel item){
        return DAOWrapper.save(item);
    }
}