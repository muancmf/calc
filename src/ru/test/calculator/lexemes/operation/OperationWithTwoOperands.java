package ru.test.calculator.lexemes.operation;

import ru.test.calculator.lexemes.operand.Operand;

public interface OperationWithTwoOperands {
    Operand evaluateWith(Operand a, Operand b);
}
