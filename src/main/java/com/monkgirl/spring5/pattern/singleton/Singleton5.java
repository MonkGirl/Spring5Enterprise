package com.monkgirl.spring5.pattern.singleton;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-23 13:45
 * @description 登记式/静态内部类，对静态域使用延迟初始化，只适应静态域的情况。
 */
public class Singleton5 {
    private static class SingletonHolder{
        private static final Singleton5 INSTANCE = new Singleton5();
    }

    private Singleton5(){

    }

    public static Singleton5 getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
