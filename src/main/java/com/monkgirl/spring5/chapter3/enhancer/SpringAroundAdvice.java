package com.monkgirl.spring5.chapter3.enhancer;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-08-14 16:20
 * @description
 */
@Component
public class SpringAroundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Before around...");
        Object obj = methodInvocation.proceed();
        System.out.println("After around...");
        return obj;
    }
}
