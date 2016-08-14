package com.samatkinson;

import static com.samatkinson.AnalyzerResponse.VALID;

public class CompositeRule {
    private String element;
    private String symbol;

    public CompositeRule(String element, String symbol){
        this.element = element;
        this.symbol = symbol;
    }

    public AnalyzerResponse createAnalyzerResponse(Rule... rules) {
        for (Rule rule : rules) {
            AnalyzerResponse check = rule.check(element, symbol);
            if(!check.valid){
                return check;
            }
        }
        return VALID;
    }
}
