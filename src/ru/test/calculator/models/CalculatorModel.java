package ru.test.calculator.models;

import ru.test.calculator.expressions.Expression;

public class CalculatorModel {
    private final Expression calculator;

    public CalculatorModel(Expression expression) {
        this.calculator = expression;
    }

    public String calculate(String displayValue) {
        return calculator.calculate(displayValue).replaceAll("\\.?0*$", "");
    }
}
