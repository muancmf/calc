package ru.test.calculator.lexemes.operation;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.test.calculator.lexemes.operand.OperandImpl;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class Operations {
    @Bean
    public Collection<Operation> basicOperations() {
        Collection<Operation> operations = new ArrayList<>();

        operations.add(new OperationImpl(10, "+", (a, b) -> new OperandImpl(a.getValue() + b.getValue())));
        operations.add(new OperationImpl(10, "-", (a, b) -> new OperandImpl(a.getValue() - b.getValue())));
        operations.add(new OperationImpl(100, "*", (a, b) -> new OperandImpl(a.getValue() * b.getValue())));
        operations.add(new OperationImpl(100, "/", (a, b) -> new OperandImpl(a.getValue() / b.getValue())));
        return operations;
    }
}
