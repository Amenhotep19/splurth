package com.samatkinson;

public class AnalyzerResponse {

    public static final AnalyzerResponse SYMBOL_LETTERS_NOT_IN_ORDER =
        new AnalyzerResponse(false, "Symbol letters must be in same order as element");

    public static final AnalyzerResponse SYMBOL_IS_NOT_TWO_LETTERS =
        new AnalyzerResponse(false, "Symbol Must Contain 2 Letters");

    public static final AnalyzerResponse SYMBOL_LETTERS_NOT_ALL_FROM_CHEM_NAME =
        new AnalyzerResponse(false, "Symbol may only contain letters in element");

    public static final AnalyzerResponse IF_LETTER_OCCURS_TWICE_MUST_BE_SYMBOL_NAME =
        new AnalyzerResponse(false, "If a letter occurs twice" +
        "then the symbol must be that letter twice");

    public static final AnalyzerResponse VALID = new AnalyzerResponse(true, "");

    public final Boolean valid;
    public final String description;

    public AnalyzerResponse(Boolean valid, String description) {
        this.valid = valid;
        this.description = description;
    }

}
