package com.monkgirl.spring5.pattern.mediator;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-28 10:10
 * @description
 */
public class User {
    private final String name;

    public String getName() {
        return name;
    }

    public User(String name){
        this.name = name;
    }

    public void sendMessage(String message){
        BBS.showMessage(this, message);
    }
}
