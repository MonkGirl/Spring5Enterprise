package com.monkgirl.spring5.pattern.strategy;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-28 16:43
 * @description
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }
    public int execute(int num1, int num2) {
        return strategy.execute(num1, num2);
    }
}
