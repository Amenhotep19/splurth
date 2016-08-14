package com.samatkinson;

public class AnalyzerResponse {

    public static final String SYMBOL_LETTERS_NOT_IN_ORDER = "Symbol letters must be in same order as element";
    public static final String SYMBOL_LETTERS_NOT_ALL_FROM_CHEM_NAME = "Symbol may only contain letters in element";
    public static String SYMBOL_IS_NOT_TWO_LETTERS = "Symbol Must Contain 2 Letters";
    public final Boolean valid;
    public final String description;

    public AnalyzerResponse(Boolean valid, String description) {
        this.valid = valid;
        this.description = description;
    }

}
