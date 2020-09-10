package com.monkgirl.spring5.chapter6.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-08 16:56
 * @description
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.monkgirl.spring5.chapter6.*")
public class WebFluxApplication {
    public static void main(String[] args){
        SpringApplication.run(WebFluxApplication.class, args);
    }
}
