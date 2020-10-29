package com.monkgirl.spring5.pattern.interpreter;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-28 09:13
 * @description
 */
public class NumericalExpression implements Expression {
    private final int value1;
    private final int value2;

    public NumericalExpression(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public boolean interpreter() {
        return (value1 - value2) > 0;
    }
}
