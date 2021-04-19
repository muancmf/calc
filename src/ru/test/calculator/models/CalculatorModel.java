package ru.test.calculator.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.test.calculator.expressions.Expression;

@Component
public class CalculatorModel {
    private final Expression calculator;

    @Autowired
    public CalculatorModel(Expression expression) {
        this.calculator = expression;
    }

    public String calculate(String displayValue) {
        return calculator.calculate(displayValue).replaceAll("\\.?0*$", "");
    }
}
