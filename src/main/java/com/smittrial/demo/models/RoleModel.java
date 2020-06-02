package com.smittrial.demo.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="role")
public class RoleModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;

    public RoleModel(){
    }

    public RoleModel(String _name){
        name = _name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String val) {
        name = val;
    }
}
