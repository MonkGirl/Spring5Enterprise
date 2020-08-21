package com.monkgirl.spring5.chapter3.enhancer;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-08-14 15:14
 * @description
 */
@Component
public class SpringBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        String methodName = method.getName();
        System.out.printf("SpringBeforeAdvice: method---%s%n", methodName);
        System.out.printf("SpringBeforeAdvice: args---%n", objects);
        System.out.printf("SpringBeforeAdvice: object---%s%n", o);
    }
}
