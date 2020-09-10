package com.monkgirl.spring5.chapter6.action;

import com.monkgirl.spring5.chapter6.entities.User;
import com.monkgirl.spring5.chapter6.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-09 16:05
 * @description
 */
@RestController
public class WebFluxController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/all")
    public Flux<User> getUser(){
        return userService.queryAllUserList();
    }

    @GetMapping("/user/{id}")
    public Mono<User> findUserById(@PathVariable("id") Long id){
        return userService.queryUserById(id);
    }
}
