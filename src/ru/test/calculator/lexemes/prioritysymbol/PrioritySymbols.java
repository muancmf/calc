package ru.test.calculator.lexemes.prioritysymbol;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class PrioritySymbols {

    @Bean
    private PrioritySymbol defaultClosing() {
        return new PrioritySymbolImpl(false, ")");
    }

    @Bean
    private PrioritySymbol defaultOpening() {
        return new PrioritySymbolImpl(true, "(");
    }
}
