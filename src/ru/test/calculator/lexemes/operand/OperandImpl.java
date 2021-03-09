package ru.test.calculator.lexemes.operand;

import ru.test.calculator.lexemes.LexemeTypes;

public class OperandImpl implements Operand {
    private LexemeTypes type;
    private Double value;

    public OperandImpl(Double value) {
        this.type = LexemeTypes.OPERAND;
        this.value = value;
    }

    @Override
    public LexemeTypes getLexemeType() {
        return this.type;
    }

    @Override
    public String getPresentation() {
        return this.value.toString();
    }

    @Override
    public Double getValue() {
        return this.value;
    }
}