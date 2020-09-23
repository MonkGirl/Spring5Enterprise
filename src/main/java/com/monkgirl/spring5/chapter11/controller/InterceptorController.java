package com.monkgirl.spring5.chapter11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-22 15:16
 * @description
 */
@Controller
@RequestMapping("/interceptor")
public class InterceptorController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello Interceptor!";
    }

    @RequestMapping("/bye")
    @ResponseBody
    public String bye(){
        return "Bye Interceptor";
    }
}
