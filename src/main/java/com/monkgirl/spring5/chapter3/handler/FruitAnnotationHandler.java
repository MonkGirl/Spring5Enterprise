package com.monkgirl.spring5.chapter3.handler;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-08-14 14:31
 * @description
 */
@Component
@Aspect
public class FruitAnnotationHandler {
    /**
     * 定义切入点
     */
    @Pointcut("execution(* com.monkgirl.spring5.entities.*.eat(..))")
    public void eatFruit(){
    }

    @Before("eatFruit()")
    public void startEatFruitDate(){
        System.out.println("[Annotation]Begin Eating Fruit Date :" +new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    @After("eatFruit()")
    public void endEatFruitDate(){
        System.out.println("[Annotation]End Eating Fruit Date :" +new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
