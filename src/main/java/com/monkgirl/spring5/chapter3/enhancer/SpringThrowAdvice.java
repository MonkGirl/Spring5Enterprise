package com.monkgirl.spring5.chapter3.enhancer;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-08-14 16:26
 * @description
 */
@Component
public class SpringThrowAdvice implements ThrowsAdvice {
    public void afterThrowing(Exception e){
        System.out.println("Spring Throw Advice...");
    }
}
