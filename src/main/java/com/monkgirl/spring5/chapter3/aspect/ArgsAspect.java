package com.monkgirl.spring5.chapter3.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-08-20 17:02
 * @description
 */
@Aspect
@Component
public class ArgsAspect {
    @Before("args(java.lang.Integer)")
    public void before(){
        System.out.println("args before java.lang.String");
    }

    @After("@args(com.monkgirl.spring5.annotation.Listen)")
    public void after(){
        System.out.println("@args after Listen");
    }
}
