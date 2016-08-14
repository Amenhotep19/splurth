package com.samatkinson;

public class AnalyzerResponse {

    public final Boolean valid;
    public final String description;

    public AnalyzerResponse(Boolean valid, String description) {
        this.valid = valid;
        this.description = description;
    }
}
