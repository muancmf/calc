package ru.test.calculator.expressions.postfixexpression;

import ru.test.calculator.expressions.Expression;
import ru.test.calculator.lexemes.Lexeme;
import ru.test.calculator.lexemes.operand.Operand;
import ru.test.calculator.lexemes.operation.Operation;
import ru.test.calculator.lexemes.prioritysymbol.PrioritySymbol;
import ru.test.calculator.parsers.StringParsers;

import java.util.Collection;
import java.util.Stack;


public class PostfixExpression implements Expression {
    private StringParsers parser;

    public PostfixExpression(StringParsers parser) {
        this.parser = parser;
    }

    @Override
    public String calculate(String expression) {
        Collection<Lexeme> lexemes = parser.parseStringToLexemes(expression);
        return CalculatePostfixForm(ConvertInfixToPostfix(lexemes)).getPresentation();
    }

    private Collection<Lexeme> ConvertInfixToPostfix(Collection<Lexeme> infixInput) {
        Stack<Lexeme> output = new Stack<>();
        Stack<Stack<Lexeme>> accumulators  = new Stack<>();

        accumulators.push(new Stack<>());

        for(Lexeme lexeme : infixInput) {
            switch (lexeme.getLexemeType()) {
                case OPERATION:
                    if(!accumulators.peek().isEmpty()) {
                        if (((Operation)accumulators.peek().peek()).getPriority() >= ((Operation)lexeme).getPriority()) {
                            while (!accumulators.peek().isEmpty()) {
                                output.push(accumulators.peek().pop());
                            }
                        }
                    }
                    accumulators.peek().push(lexeme);
                    break;
                case PRIORITYSYMBOL:
                    if(((PrioritySymbol)lexeme).isOpening() ) {
                        accumulators.push(new Stack<>());
                    } else {
                        while(!accumulators.peek().isEmpty()) {
                            output.push(accumulators.peek().pop());
                        }
                        accumulators.pop();
                    }
                    break;
                default: // OPERAND
                    output.push(lexeme);
            }
        }
        while(!accumulators.peek().isEmpty()) {
            output.push(accumulators.peek().pop());
        }

        return output;
    }

    private Lexeme CalculatePostfixForm(Collection<Lexeme> postfixInput) {
        Stack<Lexeme> output = new Stack<>();
        Operand a;
        Operand b;

        for(Lexeme lexeme : postfixInput) {
            switch (lexeme.getLexemeType()) {
                case OPERATION:
                    b = (Operand)output.pop();
                    a = (Operand)output.pop();
                    output.push(((Operation)lexeme).evaluate(a, b));
                    break;
                default: // OPERAND
                    output.push(lexeme);
            }
        }

        return output.pop();
    }
}
