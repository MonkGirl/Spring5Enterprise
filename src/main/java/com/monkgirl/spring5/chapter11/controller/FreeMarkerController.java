package com.monkgirl.spring5.chapter11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-21 11:09
 * @description
 */
@Controller
public class FreeMarkerController {

    @RequestMapping("/hello/freemarker")
    public String helloFreeMarker(ModelMap map){
        map.put("msg", "Welcome to FreeMarker World");
        return "helloFreeMarker";
    }
}
