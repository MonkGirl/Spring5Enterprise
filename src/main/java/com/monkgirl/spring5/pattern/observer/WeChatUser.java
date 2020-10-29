package com.monkgirl.spring5.pattern.observer;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-28 11:49
 * @description
 */
public class WeChatUser implements Observer{
    private final String name;
    private String message;

    public WeChatUser(String name){
        this.name = name;
    }

    @Override
    public void listen(String message) {
        this.message = message;
        System.out.printf("%s received message : %s%n", name, message);
    }
}
