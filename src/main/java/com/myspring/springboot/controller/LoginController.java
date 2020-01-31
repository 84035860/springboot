package com.myspring.springboot.controller;

import com.myspring.springboot.bean.TestUserBean;
import com.myspring.springboot.sql.LoginMapper;
import com.myspring.springboot.sql.TokenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Random;


@RestController
public class LoginController {

    @Autowired
    LoginMapper mapper;

    @Autowired
    TokenMapper tokenMapper;

    //consumes对传入的参数格式有严格的控制
    //方法参数
    // @RequestBody Map<String, Object> requestParam 是json
    // @RequestParam Map<String, Object> requestParam 是form
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded"})
    @ResponseBody
    public String login(@RequestParam Map<String, Object> requestParam) {
        TestUserBean bean = mapper.findId(requestParam.get("account").toString());
        String password = requestParam.get("password").toString();
        String token = "\"" + getToken() + "\"";
        if (bean != null)
            if (bean.getPassword().equals(password)) {
                tokenMapper.insertToken(bean.getId() + "", token);
                return "{\"error_code\":0,\"data\":[{" + "\"token\":" + token + "}]}";
            }
        return "{\"error_code\":400,\"data\":[]}";
    }

    private String getToken() {
        String range = "0123456789abcdefghijklmnopqrstuvwxyz!@#$%^&*()_+";
        Random random = new Random();

        StringBuffer result = new StringBuffer();
        //要生成几位，就把这里的数字改成几
        for (int i = 0; i < 21; i++) {
            result.append(range.charAt(random.nextInt(range.length())));
        }

        return result.toString();
    }
}
