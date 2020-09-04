package com.monkgirl.spring5.chapter3.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-08-21 15:57
 * @description
 */
@Aspect
@Component
public class TargetAspect {
    //@Before("target(com.monkgirl.spring5.entities.HuaweiPhoneFactory)")
    public void before(){
        System.out.println("Target to PhoneFactory.");
    }

   // @After("@target(com.monkgirl.spring5.annotation.Run)")
    public void after(){
        System.out.println("@Target to PhoneFactory.");
    }
}
