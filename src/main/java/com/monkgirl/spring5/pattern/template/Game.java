package com.monkgirl.spring5.pattern.template;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-28 16:55
 * @description
 */
public abstract class Game {
    abstract void init();
    abstract void start();
    abstract void pause();
    abstract void end();

    public void play(){
        init();
        start();
        pause();
        end();
    }
}
