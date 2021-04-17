package ru.test.calculator.lexemes.prioritysymbol;

import java.util.ArrayList;
import java.util.Collection;

public class PrioritySymbols {
    public Collection<PrioritySymbol> prioritySymbols() {
        Collection<PrioritySymbol> prioritySymbols = new ArrayList<>();

        prioritySymbols.add(new PrioritySymbolImpl(true, "("));
        prioritySymbols.add(new PrioritySymbolImpl(false, ")"));
        return prioritySymbols;
    }
}
