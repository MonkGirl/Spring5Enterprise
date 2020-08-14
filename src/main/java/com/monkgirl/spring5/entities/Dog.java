package com.monkgirl.spring5.entities;

import com.monkgirl.spring5.interfaces.Animal;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-08-11 17:48
 * @description
 */
public class Dog implements Animal {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println("The Dog is eating...");
    }
}
