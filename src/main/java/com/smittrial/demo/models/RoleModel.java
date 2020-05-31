package com.smittrial.demo.models;

import java.util.ArrayList;
import java.util.List;

public class RoleModel {
    private String name;
    private List<Integer> allowedActions;

    public RoleModel(String _name, List<Integer> _allowedActions){
        name = _name;
        allowedActions = _allowedActions;
    }
}
