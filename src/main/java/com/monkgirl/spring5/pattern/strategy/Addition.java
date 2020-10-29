package com.monkgirl.spring5.pattern.strategy;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-28 16:41
 * @description
 */
public class Addition implements Strategy {
    @Override
    public int execute(int num1, int num2) {
        return num1 + num2;
    }
}
