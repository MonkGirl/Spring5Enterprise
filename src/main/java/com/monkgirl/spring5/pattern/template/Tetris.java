package com.monkgirl.spring5.pattern.template;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-28 16:56
 * @description
 */
public class Tetris extends Game {
    @Override
    void init() {
        System.out.println("Init Tetris Game. ");
    }

    @Override
    void start() {
        System.out.println("Start Tetris Game. ");
    }

    @Override
    void pause() {
        System.out.println("Pause Tetris Game. ");
    }

    @Override
    void end() {
        System.out.println("End Tetris Game. ");
    }
}
