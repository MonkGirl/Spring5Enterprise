package com.monkgirl.spring5.chapter3.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-08-21 14:17
 * @description
 */
@Aspect
@Component
public class AnnotationAspect {

    @AfterReturning("@annotation(com.monkgirl.spring5.annotation.Log)")
    public void log(){
        System.out.println("Log is work...");
    }
}
