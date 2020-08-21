package com.monkgirl.spring5.chapter3.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-08-21 14:42
 * @description
 */
@Aspect
@Component
public class ExecutionAspect {

    @AfterReturning("execution(* com.monkgirl.spring5.interfaces.Factory.make())")
    public void make(){
        System.out.println("Execute make...");
    }
}
