package com.samatkinson;

public class ChemicalAnalyzer {
    public AnalyzerResponse isValid(String element, String symbol) {
        element = element.toLowerCase();
        symbol = symbol.toLowerCase();

        return createAnalyzerResponse(symbolContainsTwoLetters(symbol),
            containsLettersFromElementInOrder(element, symbol),
            letterOccursTwiceForceNameToBeThatLetterTwice(element, symbol));
    }

    private AnalyzerResponse createAnalyzerResponse(AnalyzerResponse... responses) {
        for (AnalyzerResponse response : responses) {
            if (!response.valid)
                return response;
        }
        return new AnalyzerResponse(true, "");
    }

    private AnalyzerResponse symbolContainsTwoLetters(String symbol) {
        return new AnalyzerResponse(symbol.length() == 2, AnalyzerResponse.SYMBOL_IS_NOT_TWO_LETTERS);
    }

    private AnalyzerResponse letterOccursTwiceForceNameToBeThatLetterTwice(String element, String symbol) {
        for (int i = 0; i < element.length() - 1; i++) {
            char elementUnderInspection = element.charAt(i);
            if (element.substring(i + 1).contains("" + elementUnderInspection))
                return new AnalyzerResponse(symbol.equals(elementUnderInspection + "" + elementUnderInspection), "");
        }
        return new AnalyzerResponse(true, "");
    }

    private AnalyzerResponse containsLettersFromElementInOrder(String element, String symbol) {
        int firstCharacterLocation = element.indexOf(symbol.charAt(0));
        String restOfSequence = element.substring(firstCharacterLocation + 1);

        char secondCharOfSymbol = symbol.charAt(1);

        if (!restOfSequence.contains("" + secondCharOfSymbol))
            return new AnalyzerResponse(false,
                element.contains("" + secondCharOfSymbol) ?
                    AnalyzerResponse.SYMBOL_LETTERS_NOT_IN_ORDER :
                    AnalyzerResponse.SYMBOL_LETTERS_NOT_ALL_FROM_CHEM_NAME);

        return new AnalyzerResponse(true, "");
    }
}
