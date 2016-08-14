package com.samatkinson;

public class AnalyzerResponse {

    public static String CHEMICAL_IS_NOT_TWO_LETTERS = "Symbol Must Contain 2 Letters";
    public final Boolean valid;
    public final String description;

    public AnalyzerResponse(Boolean valid, String description) {
        this.valid = valid;
        this.description = description;
    }
}
