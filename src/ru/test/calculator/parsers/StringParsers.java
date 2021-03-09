package ru.test.calculator.parsers;

import ru.test.calculator.lexemes.Lexeme;
import ru.test.calculator.lexemes.operand.Operand;
import ru.test.calculator.lexemes.operand.OperandImpl;
import ru.test.calculator.lexemes.operation.Operations;
import ru.test.calculator.lexemes.prioritysymbol.PrioritySymbols;

import java.util.*;

public class StringParsers {
    private static final List<String> DELIMETERS = Arrays.asList(",", ".");
    private static final String SYS_DELIMETER = ".";

    public Collection<Lexeme> parseStringToLexemes(String input) {
        Collection<Lexeme> result = new ArrayList<>();
        String multiSymbolLexemeBuffer = "";
        Collection<Lexeme> lexemeOptions = new ArrayList<>();

        lexemeOptions.addAll(new PrioritySymbols().prioritySymbols);
        lexemeOptions.addAll(new Operations().operations);

        for(String symbol : input.split("")) {
            Optional<Lexeme> lexeme = lexemeOptions.stream().filter(l -> l.getPresentation().equals(symbol)).findFirst();
            if(lexeme.isPresent()) {
                if(multiSymbolLexemeBuffer.length() > 0) {
                    result.add(operandWithValue(multiSymbolLexemeBuffer));
                    multiSymbolLexemeBuffer = "";
                }
                result.add(lexeme.get());
            } else {
                if(DELIMETERS.contains(symbol)) {
                    multiSymbolLexemeBuffer += SYS_DELIMETER;
                } else {
                    multiSymbolLexemeBuffer += symbol;
                }
            }
        }
        if(multiSymbolLexemeBuffer.length() > 0) {
            result.add(operandWithValue(multiSymbolLexemeBuffer));
        }

        return result;
    }

    private Operand operandWithValue(String value) {
        return new OperandImpl(Double.parseDouble(value));
    }
}
