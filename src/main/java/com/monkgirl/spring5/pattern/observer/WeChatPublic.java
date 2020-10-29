package com.monkgirl.spring5.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-28 11:53
 * @description
 */
public class WeChatPublic {
    private List<Observer> observerList;

    private String message;

    public WeChatPublic(){
        observerList = new ArrayList<>();
    }

    public void setMessage(String message){
        this.message = message;
        System.out.println("updated message : " + message);
        notifyObserverList();
    }

    public void addObserver(Observer observer){
        observerList.add(observer);
    }

    public void notifyObserverList(){
        for(Observer observer : observerList){
            observer.listen(message);
        }
    }
}
