package ru.test.calculator.models;

import ru.test.calculator.expressions.Expression;
import ru.test.calculator.expressions.postfixexpression.PostfixExpression;

public class CalculatorModel {
    private Expression calculator;

    public CalculatorModel() {
        this.calculator = new PostfixExpression();
    }

    public String calculate(String displayValue) {
        return calculator.calculate(displayValue).replaceAll("\\.?0*$", "");
    }
}
