package ru.test.calculator.lexemes.prioritysymbol;

import java.util.ArrayList;
import java.util.Collection;

public class PrioritySymbols {
    public Collection<PrioritySymbol> prioritySymbols;

    public PrioritySymbols() {
        this.prioritySymbols = new ArrayList<>();

        this.prioritySymbols.add(new PrioritySymbolImpl(true,"("));
        this.prioritySymbols.add(new PrioritySymbolImpl(false,")"));
    }
}
