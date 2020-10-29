package com.monkgirl.spring5.pattern.interpreter;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-28 09:15
 * @description
 */
public class AndExpression implements Expression {
    private final Expression expression1;
    private final Expression expression2;

    public AndExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpreter() {
        return expression1.interpreter() && expression2.interpreter();
    }
}
