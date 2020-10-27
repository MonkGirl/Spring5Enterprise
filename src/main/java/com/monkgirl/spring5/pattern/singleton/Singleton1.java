package com.monkgirl.spring5.pattern.singleton;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-23 10:55
 * @description 饿汉式，没有加锁，执行效率高；类加载时就初始化，浪费内存。
 */
public class Singleton1 {
    private static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1(){

    }

    public static Singleton1 getInstance(){
        return INSTANCE;
    }
}
