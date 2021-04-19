package ru.test.calculator.lexemes.operation;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.test.calculator.lexemes.operand.OperandImpl;

@Component
public class Operations {

    @Bean
    private Operation div() {
        return new OperationImpl(100, "/", (a, b) -> new OperandImpl(a.getValue() / b.getValue()));
    }

    @Bean
    private Operation mul() {
        return new OperationImpl(100, "*", (a, b) -> new OperandImpl(a.getValue() * b.getValue()));
    }

    @Bean
    private Operation sub() {
        return new OperationImpl(10, "-", (a, b) -> new OperandImpl(a.getValue() - b.getValue()));
    }

    @Bean
    private Operation sum() {
        return new OperationImpl(10, "+", (a, b) -> new OperandImpl(a.getValue() + b.getValue()));
    }
}
