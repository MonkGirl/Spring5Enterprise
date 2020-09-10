package com.monkgirl.spring5.chapter6.action;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-07 17:02
 * @description
 */
@RestController
public class HelloController {

    @GetMapping("/helloFlux")
    public Mono<String> helloFlux(){
        return Mono.just("Welcome to webflux world! ");
    }
}
