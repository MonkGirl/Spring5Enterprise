package com.monkgirl.spring5.chapter3.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-08-18 11:59
 * @description
 */
@Aspect
@Component
public class AllAspect {

    @Before("execution(* com.monkgirl.spring5.comm.entities.Person.*(..))")
    public void before(){
        System.out.println("Aspect Before Advice...");
    }

    @Around("execution(* com.monkgirl.spring5.comm.entities.Person.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Around Advice Before...");
        Object obj = joinPoint.proceed();
        System.out.println("Around Advice After...");
        return obj;
    }

    @AfterReturning("execution(* com.monkgirl.spring5.comm.entities.Person.*(..))")
    public void afterReturning(){
        System.out.println("AfterReturning Advice...");
    }

    @After("execution(* com.monkgirl.spring5.comm.entities.Person.*(..))")
    public void after(){
        System.out.println("After Advice...");
    }

    @AfterThrowing("execution(* com.monkgirl.spring5.comm.entities.Person.*(..))")
    public void afterThrowing(){
        System.out.println("After Throwing Advice...");
    }
}
