package com.myspring.springboot.controller.test;

import com.myspring.springboot.bean.StudentBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @Value("${name}")
    private String name;

    @Value("${age}")
    private Integer age;

    @Autowired
    private StudentBean studentBean;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return name+age+studentBean.getName()+studentBean.getAge();
    }

}
