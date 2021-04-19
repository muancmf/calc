package ru.test.calculator.parsers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.test.calculator.lexemes.Lexeme;
import ru.test.calculator.lexemes.operand.Operand;
import ru.test.calculator.lexemes.operand.OperandImpl;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class StringParsers {
    private static final List<String> DELIMITERS = Arrays.asList(",", ".");
    private static final String SYS_DELIMITER = ".";

    private Collection<Lexeme> lexemeOptions;

    @Autowired
    public StringParsers(Collection<Lexeme> lexemeOptions) {
        this.lexemeOptions = lexemeOptions;
    }

    public Collection<Lexeme> parseStringToLexemes(String input) {
        List<Object> digitsAndLexemes = new ArrayList<>();
        digitsAndLexemes.add(input);

        for (Lexeme lexeme : this.lexemeOptions) {
            List<Object> subResult = new ArrayList<>();
            for (Object item : digitsAndLexemes) {
                if (item.getClass() == String.class) {
                    String tail = (String) item;
                    while (tail.length() > 0) {
                        int index = tail.indexOf(lexeme.getPresentation());
                        if (index >= 0) {
                            if (index > 0) {
                                subResult.add(tail.substring(0, index));
                            }
                            tail = tail.substring(index + lexeme.getPresentation().length());
                            subResult.add(lexeme);
                        } else {
                            subResult.add(tail);
                            tail = "";
                        }
                    }
                } else {
                    subResult.add(item);
                }
            }
            digitsAndLexemes.clear();
            digitsAndLexemes.addAll(subResult);
        }

        Collection<Lexeme> result = new ArrayList<>();
        for (Object lexeme : digitsAndLexemes) {
            if (lexeme.getClass() == String.class) {
                result.add(operandWithValue((String) lexeme));
            } else {
                result.add((Lexeme) lexeme);
            }
        }
        return result;
    }

    private Operand operandWithValue(String value) {
        value = Arrays.stream(value.split(""))
                .map(c -> DELIMITERS.contains(c) ? SYS_DELIMITER : c)
                .collect(Collectors.joining());
        return new OperandImpl(Double.parseDouble(value));
    }
}
