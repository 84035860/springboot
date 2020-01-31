package com.myspring.springboot.bean;

import java.io.Serializable;

public class TestUserBean implements Serializable {
    Integer id;
    String account;
    String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "{\"id\":"+id+",\"account\":"+account+",\"password\":"+password+"}";
    }
}