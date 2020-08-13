package com.monkgirl.spring5.chapter3.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-08-12 16:01
 * @description
 */
public class AnimalInvocationHandler implements InvocationHandler {

    /**
     * 被代理的对象
     */
    private Object target;

    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        Object result = null;
        System.out.println("Before proxy...");
        result = method.invoke(target, objects);
        System.out.println("After proxy...");
        return result;
    }
}
