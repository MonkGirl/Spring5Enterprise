package com.monkgirl.spring5.chapter3.handler;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-08-14 14:56
 * @description
 */
@Component
@Aspect
public class CglibXmlAspect {
    @Before("execution(* com.monkgirl.spring5.entities.*.location(..))")
    public void beforeLocation(){
        System.out.println("Before Location...");
    }

    @After("execution(* com.monkgirl.spring5.entities.*.location(..))")
    public void afterLocation(){
        System.out.println("After Location...");
    }
}
