package com.smittrial.demo.models;

import javax.persistence.*;

@Entity
@Table(name="user")
public class UserModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private String ssn;

    public UserModel() {
    }
    public UserModel(String _email, String _password, String _firstname, String _lastname, String _ssn) {
        email = _email;
        password = _password;
        firstname = _firstname;
        lastname = _lastname;
        ssn = _ssn;
    }
    public String toString() {
        return String.format("ID: %d Name: %s %s Email: %s SSN: %s",
                getId(), getFirstname(), getLastname(), getEmail(), getSsn());
    }

    public int getId() {
        return id;
    }
    public void setId(int _id) {
        id = _id;
    }

    public String getEmail() {
        return email;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public String getSsn() {
        return ssn;
    }
    public String getPassword() {
        return password;
    }

    public void setEmail(String val) {
        email = val;
    }
    public void setPassword(String val) {
        password = val;
    }
    public void setFirstname(String val) {
        firstname = val;
    }
    public void setLastname(String val) {
        lastname = val;
    }
    public void setSsn(String val) {
        ssn = val;
    }

    public boolean hasRole(String roleName) {
        // TODO
        return true;
    }
}
