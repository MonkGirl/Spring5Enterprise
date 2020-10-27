package com.monkgirl.spring5.pattern.singleton;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-23 11:50
 * @description 双检锁 DCL（Double-Checked Locking）
 */
public class Singleton4 {
    private volatile static Singleton4 instance;

    private Singleton4() {

    }

    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}
