package com.monkgirl.spring5.chapter6.entities;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-09-08 11:00
 * @description
 */
public class User {

    private Long id;
    private String name;

    public User(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
