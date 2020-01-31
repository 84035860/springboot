package com.myspring.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
    @RequestMapping(value = "/")
    public String login(){
        return "index";
    }

    @RequestMapping(value = "/main")
    public String main(){
        return "main";
    }
}
