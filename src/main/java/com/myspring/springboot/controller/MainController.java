package com.myspring.springboot.controller;

import com.myspring.springboot.bean.TestUserBean;
import com.myspring.springboot.bean.TestUserInfoBean;
import com.myspring.springboot.sql.TokenMapper;
import com.myspring.springboot.sql.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MainController {

    @Autowired
    UserInfoMapper userMapper;

    @Autowired
    TokenMapper tokenMapper;

    @RequestMapping(value = "/main_data")
    public String main(@RequestBody Map<String, Object> requestParam){
        Integer id = tokenMapper.findId("\""+requestParam.get("token").toString()+"\"").getId();
        TestUserInfoBean bean = userMapper.findId(id);
        return bean.toString();
    }

}
