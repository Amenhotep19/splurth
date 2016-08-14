package com.samatkinson;

public class ChemicalAnalyzer {
    public AnalyzerResponse isValid(String element, String symbol) {
        element = element.toLowerCase();
        symbol = symbol.toLowerCase();

        return new AnalyzerResponse(symbol.length() == 2
            && containsLettersFromElement(element, symbol)
            && letterOccursTwiceForceNameToBeThatLetterTwice(element, symbol),"");
    }

    private boolean letterOccursTwiceForceNameToBeThatLetterTwice(String element, String symbol) {
        for (int i = 0; i < element.length() -1; i++) {
            char elementUnderInspection = element.charAt(i);
            if(element.substring(i+1).contains("" + elementUnderInspection))
                return symbol.equals(elementUnderInspection + "" +  elementUnderInspection);
        }
        return true;
    }

    private boolean containsLettersFromElement(String element, String symbol) {
        String restOfSequence = element;
        for (int i = 0; i < symbol.length(); i++) {
            char c = symbol.charAt(i);
            if(!restOfSequence.contains(""+c)) return false;
            restOfSequence = element.substring(element.indexOf(c));

        }
        return true;
    }
}
