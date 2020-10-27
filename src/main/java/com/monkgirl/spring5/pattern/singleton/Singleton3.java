package com.monkgirl.spring5.pattern.singleton;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-23 11:45
 * @description 懒汉式，线程安全，第一次调用才初始化，避免浪费内存，synchronized影响效率
 */
public class Singleton3 {
    private static Singleton3 instance;

    private Singleton3() {

    }

    public static synchronized Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}
