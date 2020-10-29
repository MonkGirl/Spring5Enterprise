package com.monkgirl.spring5.pattern.template;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-28 16:58
 * @description
 */
public class SuperMarie extends Game {
    @Override
    void init() {
        System.out.println("Init SuperMarie Game.");
    }

    @Override
    void start() {
        System.out.println("Start SuperMarie Game.");
    }

    @Override
    void pause() {
        System.out.println("Pause SuperMarie Game.");
    }

    @Override
    void end() {
        System.out.println("End SuperMarie Game.");
    }
}
