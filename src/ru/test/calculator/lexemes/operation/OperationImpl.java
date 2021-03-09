package ru.test.calculator.lexemes.operation;

import ru.test.calculator.lexemes.LexemeTypes;
import ru.test.calculator.lexemes.operand.Operand;

public class OperationImpl implements Operation {
    private Integer priority;
    private LexemeTypes type;
    private String presentation;
    private OperationWithTwoOperands closure;

    public OperationImpl(Integer priority, String presentation, OperationWithTwoOperands closure) {
        this.type = LexemeTypes.OPERATION;
        this.priority = priority;
        this.presentation = presentation;
        this.closure = closure;
    }

    @Override
    public LexemeTypes getLexemeType() {
        return this.type;
    }

    @Override
    public Integer getPriority() {
        return this.priority;
    }

    @Override
    public String getPresentation() {
        return this.presentation;
    }

    @Override
    public Operand evaluate(Operand a, Operand b) {
        return this.closure.evaluateWith(a, b);
    }
}
