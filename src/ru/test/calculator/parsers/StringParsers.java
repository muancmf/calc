package ru.test.calculator.parsers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.test.calculator.lexemes.Lexeme;
import ru.test.calculator.lexemes.operand.Operand;
import ru.test.calculator.lexemes.operand.OperandImpl;
import ru.test.calculator.lexemes.operation.Operation;
import ru.test.calculator.lexemes.prioritysymbol.PrioritySymbol;

import java.util.*;

@Component
public class StringParsers {
    private static final List<String> DELIMETERS = Arrays.asList(",", ".");
    private static final String SYS_DELIMETER = ".";

    private Collection<Lexeme> lexemeOptions;

    @Autowired
    public StringParsers(Collection<PrioritySymbol> prioritySymbols, Collection<Operation> operations) {
        Collection<Lexeme> lexemeOptions = new ArrayList<>();
        lexemeOptions.addAll(prioritySymbols);
        lexemeOptions.addAll(operations);
        this.lexemeOptions = lexemeOptions;
    }

    public Collection<Lexeme> parseStringToLexemes(String input) {
        Collection<Lexeme> result = new ArrayList<>();
        String multiSymbolLexemeBuffer = "";

        for (String symbol : input.split("")) {
            Optional<Lexeme> lexeme = this.lexemeOptions.stream().filter(l -> l.getPresentation().equals(symbol)).findFirst();
            if (lexeme.isPresent()) {
                if (multiSymbolLexemeBuffer.length() > 0) {
                    result.add(operandWithValue(multiSymbolLexemeBuffer));
                    multiSymbolLexemeBuffer = "";
                }
                result.add(lexeme.get());
            } else {
                if (DELIMETERS.contains(symbol)) {
                    multiSymbolLexemeBuffer += SYS_DELIMETER;
                } else {
                    multiSymbolLexemeBuffer += symbol;
                }
            }
        }
        if (multiSymbolLexemeBuffer.length() > 0) {
            result.add(operandWithValue(multiSymbolLexemeBuffer));
        }

        return result;
    }

    private Operand operandWithValue(String value) {
        return new OperandImpl(Double.parseDouble(value));
    }
}
