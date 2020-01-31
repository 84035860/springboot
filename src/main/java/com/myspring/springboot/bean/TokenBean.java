package com.myspring.springboot.bean;

import java.io.Serializable;

public class TokenBean implements Serializable {

    String token;

    Integer id;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
