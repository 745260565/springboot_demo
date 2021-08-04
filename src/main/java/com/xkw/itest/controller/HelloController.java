package com.xkw.itest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : chenghao
 * create at:  2021/3/25  4:37 下午
 * @description:
 */

@Controller
public class HelloController {

    @RequestMapping("/index")
    public String sayHello() {
        return "index";
    }
}

