package ru.test.calculator.lexemes.prioritysymbol;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class PrioritySymbols {
    @Bean
    public Collection<PrioritySymbol> defaultPrioritySymbols() {
        Collection<PrioritySymbol> prioritySymbols = new ArrayList<>();

        prioritySymbols.add(new PrioritySymbolImpl(true, "("));
        prioritySymbols.add(new PrioritySymbolImpl(false, ")"));
        return prioritySymbols;
    }
}
