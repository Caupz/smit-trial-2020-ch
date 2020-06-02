package com.smittrial.demo.service;

import com.smittrial.demo.models.RoleModel;

import java.util.Collection;

public interface RoleService {
    Collection<RoleModel> getAll();
    RoleModel getById(int id);
    Integer add(RoleModel item);
    RoleModel update(RoleModel item);
    void remove(int id);
}
