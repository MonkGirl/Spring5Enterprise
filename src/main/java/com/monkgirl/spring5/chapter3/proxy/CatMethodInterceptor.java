package com.monkgirl.spring5.chapter3.proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author MissYoung
 * @Version 0.1
 * @Date 2020-08-12 17:01
 * @Description
 */
public class CatMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before proxy...");
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("After proxy...");
        return object;
    }
}
