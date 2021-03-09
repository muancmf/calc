package ru.test.calculator.lexemes.operation;

import ru.test.calculator.lexemes.Lexeme;
import ru.test.calculator.lexemes.operand.Operand;

public interface Operation extends Lexeme {
    Integer getPriority();
    Operand evaluate(Operand a, Operand b);
}
