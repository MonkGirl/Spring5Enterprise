package com.monkgirl.spring5.chapter3.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-08-24 16:26
 * @description
 */
@Aspect
@Component
public class ThisAspect implements Ordered {
    @Override
    public int getOrder() {
        return 1;
    }

    @After("this(com.monkgirl.spring5.interfaces.Listener)")
    public void after(){
        System.out.println("After This Aspect...");
    }

    @Before("target(com.monkgirl.spring5.interfaces.Listener)")
    public void before(){
        System.out.println("Before Target Aspect...");
    }
}
