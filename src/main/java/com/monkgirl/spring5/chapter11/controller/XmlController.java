package com.monkgirl.spring5.chapter11.controller;

import com.monkgirl.spring5.chapter11.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-21 14:59
 * @description
 */
@Controller
public class XmlController {
    @RequestMapping("/hello/xml")
    @ResponseBody
    public User getUser(){
        User user = new User();
        user.setUserName("Icarus");
        user.setUserAge(30);
        return user;
    }
}
