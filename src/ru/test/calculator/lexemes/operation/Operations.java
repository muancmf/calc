package ru.test.calculator.lexemes.operation;

import ru.test.calculator.lexemes.operand.OperandImpl;

import java.util.ArrayList;
import java.util.Collection;

public class Operations {
    public Collection<Operation> operations() {
        Collection<Operation> operations = new ArrayList<>();

        operations.add(new OperationImpl(10, "+", (a, b) -> new OperandImpl(a.getValue() + b.getValue())));
        operations.add(new OperationImpl(10, "-", (a, b) -> new OperandImpl(a.getValue() - b.getValue())));
        operations.add(new OperationImpl(100, "*", (a, b) -> new OperandImpl(a.getValue() * b.getValue())));
        operations.add(new OperationImpl(100, "/", (a, b) -> new OperandImpl(a.getValue() / b.getValue())));
        return operations;
    }
}
