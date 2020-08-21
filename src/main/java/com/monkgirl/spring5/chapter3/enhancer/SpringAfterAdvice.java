package com.monkgirl.spring5.chapter3.enhancer;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-08-14 16:15
 * @description
 */
@Component
public class SpringAfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object target) throws Throwable {
        String methodName = method.getName();
        System.out.printf("SpringAfterAdvice: method---%s%n", methodName);
        System.out.printf("SpringAfterAdvice: args---%n", objects);
        System.out.printf("SpringAfterAdvice: object---%s%n", o);
        System.out.printf("SpringAfterAdvice: object---%s%n", target);
    }
}
