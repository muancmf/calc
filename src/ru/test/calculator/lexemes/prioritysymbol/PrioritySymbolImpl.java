package ru.test.calculator.lexemes.prioritysymbol;


import ru.test.calculator.lexemes.LexemeTypes;

public class PrioritySymbolImpl implements PrioritySymbol {
    private LexemeTypes type;
    private boolean isOpening;
    private String presentation;

    PrioritySymbolImpl(boolean isOpening, String presentation) {
        this.type = LexemeTypes.PRIORITYSYMBOL;
        this.isOpening = isOpening;
        this.presentation = presentation;
    }

    @Override
    public LexemeTypes getLexemeType() {
        return this.type;
    }

    @Override
    public boolean isOpening() {
        return this.isOpening;
    }

    public String getPresentation() {
        return this.presentation;
    }
}
