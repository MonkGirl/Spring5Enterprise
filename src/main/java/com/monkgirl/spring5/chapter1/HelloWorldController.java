package com.monkgirl.spring5.chapter1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MissYoung
 * @version 0.1
 * @description
 * @date 2020-04-04 18:37
 */
@RestController
@RequestMapping("/")
public class HelloWorldController {

    @RequestMapping("hello")
    public String sayHello(){
        return "Hello World!";
    }
}
