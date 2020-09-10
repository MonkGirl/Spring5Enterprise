package com.monkgirl.spring5.chapter3.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-04 15:17
 * @description
 */
@Aspect
@Component
public class WithinAspect {

    @Before("within(com.monkgirl.spring5.comm.entities.FoodFactory)")
    public void before(){
        System.out.println("Before within aspect ...");
    }

    @After("@within(com.monkgirl.spring5.annotation.Monitor)")
    public void after(){
        System.out.println("After @within aspect");
    }
}
