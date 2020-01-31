package com.myspring.springboot.controller.test;

import com.myspring.springboot.bean.TestUserInfoBean;
import com.myspring.springboot.sql.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class UserInfoController {

    @Autowired
    UserInfoMapper userMapper;

    @RequestMapping(value = "select_test_user_all")
    private String select_test_user_all(){
        String log = "";
        List<TestUserInfoBean> userBeans = userMapper.findAll();

        for(TestUserInfoBean bean : userBeans){
            log += bean.toString() +"<form action='/select_test_user' method = 'post'>" +
                    "<input type='hidden' name='id' value='"+bean.getId()+"'/>"+
                    "<button type='submit'>修改</button>" +
                    "</form>"
                    +"<form action='/delete_test_user' method = 'post'>" +
                    "<input type='hidden' name='id' value='"+bean.getId()+"'/>"+
                    "<button type='submit'>删除</button>" +
                    "</form>"
                    + "</br>";

        }
        log += "<form action='/insert_test_user' method = 'post'>" +
                "<button type='submit'>新增</button>" +
                "</form>";
        return log;
    }

    @RequestMapping(value = "select_test_user",method = RequestMethod.POST)
    private String select_test_user(HttpServletRequest request, HttpServletResponse response){
        String log = "";
        List<TestUserInfoBean> userBeans = userMapper.findAll();

        for(TestUserInfoBean bean : userBeans){
            if(bean.getId().equals(Integer.valueOf(request.getParameter("id")))){
                log = "id:"+bean.getId()+
                      "<form action='update_test_user' method='post'>"+
                        "<input type='hidden' name='id' value='"+bean.getId()+"'/></br>"+
                        "<input type='text' name ='name' value='"+bean.getName()+"'/></br>"+
                        "<input type='text' name ='age' value='"+bean.getAge()+"'/></br>"+
                        "<input type='text' name ='info' value='"+bean.getInfo()+"'/></br>"+
                        "<button type='submit'>修改</button>" +
                      "</form>";

            }
        }
        return log;
    }

    @RequestMapping(value = "update_test_user",method = RequestMethod.POST)
    private String update_test_user(TestUserInfoBean userBean){
        int request= userMapper.updateAll(userBean);

        return request+"";
    }

    @RequestMapping(value = "insert_test_user",method = RequestMethod.POST)
    private String insert_test_user(TestUserInfoBean userBean){
        int request= userMapper.insertAll(userBean);

        return request+"";
    }

    @RequestMapping(value = "delete_test_user",method = RequestMethod.POST)
    private String delete_test_user(HttpServletRequest requests, HttpServletResponse responses){
        int request= userMapper.deleteAll(requests.getParameter("id"));

        return request+"";
    }

}
