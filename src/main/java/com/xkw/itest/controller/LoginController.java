package com.xkw.itest.controller;

import com.xkw.itest.bean.UserBean;
import com.xkw.itest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author : chenghao
 * create at:  2021/3/26  3:18 下午
 * @description:
 */

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String show() {
        return "login";
    }

    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
    public String login(String name, String password) {
        UserBean userBean = userService.loginIn(name,password);
        if (userBean != null) {
            return "success";
        }else {
            return "error";
        }
    }





}

