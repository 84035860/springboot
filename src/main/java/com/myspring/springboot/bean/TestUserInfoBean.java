package com.myspring.springboot.bean;

import java.io.Serializable;

public class TestUserInfoBean implements Serializable {
    Integer id;
    String name;
    Integer age;
    String info;
    Integer permission;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "{\"id\":"+id+",\"name\":\""+name+"\",\"age\":"+age+",\"permission\":"+permission+",\"info\":\""+info+"\"}";
    }
}
