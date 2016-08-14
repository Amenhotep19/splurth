package com.samatkinson;

public class ChemicalAnalyzer {
    public AnalyzerResponse isValid(String element, String symbol) {
        element = element.toLowerCase();
        symbol = symbol.toLowerCase();

        return createAnalyzerResponse(symbolContainsTwoLetters(symbol),
            containsLettersFromElement(element, symbol),
            letterOccursTwiceForceNameToBeThatLetterTwice(element, symbol));
    }

    private AnalyzerResponse createAnalyzerResponse(AnalyzerResponse... responses) {
        for (AnalyzerResponse response : responses) {
            if(!response.valid)
                return response;
        }
        return new AnalyzerResponse(true, "");
    }

    private AnalyzerResponse symbolContainsTwoLetters(String symbol) {
        return new AnalyzerResponse(symbol.length() == 2, AnalyzerResponse.CHEMICAL_IS_NOT_TWO_LETTERS);
    }

    private AnalyzerResponse letterOccursTwiceForceNameToBeThatLetterTwice(String element, String symbol) {
        for (int i = 0; i < element.length() -1; i++) {
            char elementUnderInspection = element.charAt(i);
            if(element.substring(i+1).contains("" + elementUnderInspection))
                return new AnalyzerResponse(symbol.equals(elementUnderInspection + "" +  elementUnderInspection), "");
        }
        return new AnalyzerResponse(true, "");
    }

    private AnalyzerResponse containsLettersFromElement(String element, String symbol) {
        String restOfSequence = element;
        for (int i = 0; i < symbol.length(); i++) {
            char c = symbol.charAt(i);
            if(!restOfSequence.contains(""+c)) return new AnalyzerResponse(false, "");
            restOfSequence = element.substring(element.indexOf(c));

        }
        return new AnalyzerResponse(true, "");
    }
}
