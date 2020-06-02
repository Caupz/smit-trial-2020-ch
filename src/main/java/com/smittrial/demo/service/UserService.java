package com.smittrial.demo.service;

import com.smittrial.demo.models.UserModel;

import java.util.Collection;

public interface UserService {
    Collection<UserModel> getAll();
    UserModel getById(int id);
    Integer add(UserModel product);
    UserModel update(UserModel product);
    void remove(int id);
}
