package com.monkgirl.spring5.pattern.singleton;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-23 11:40
 * @description 懒汉式，不支持多线程，没有synchronized，严格意义上不算是单例模式。
 */
public class Singleton2 {
    private static Singleton2 instance;
    private Singleton2(){

    }

    public static Singleton2 getInstance(){
        if(instance == null){
            instance = new Singleton2();
        }
        return instance;
    }
}
