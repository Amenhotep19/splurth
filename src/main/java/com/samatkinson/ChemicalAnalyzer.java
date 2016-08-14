package com.samatkinson;

import static com.samatkinson.AnalyzerResponse.*;

public class ChemicalAnalyzer {
    public AnalyzerResponse isValid(String element, String symbol) {
        element = element.toLowerCase();
        symbol = symbol.toLowerCase();

        CompositeRule compositeRule = new CompositeRule(element, symbol);

        return compositeRule.createAnalyzerResponse(
            (ele, sym) -> symbolContainsTwoLetters(sym),
            (ele, sym) -> containsLettersFromElementInOrder(ele, sym),
            (ele, sym) -> letterOccursTwiceForceNameToBeThatLetterTwice(ele, sym));
    }

    private AnalyzerResponse symbolContainsTwoLetters(String symbol) {
        return response(symbol.length() == 2, SYMBOL_IS_NOT_TWO_LETTERS);
    }

    private AnalyzerResponse response(boolean b, AnalyzerResponse symbolIsNotTwoLetters) {
        return b ? VALID : symbolIsNotTwoLetters;
    }

    private AnalyzerResponse letterOccursTwiceForceNameToBeThatLetterTwice(String element, String symbol) {
        for (int i = 0; i < element.length() - 1; i++) {
            char elementUnderInspection = element.charAt(i);
            if (element.substring(i + 1).contains("" + elementUnderInspection)) {
                return response(
                    symbol.equals(elementUnderInspection + "" + elementUnderInspection),
                    IF_LETTER_OCCURS_TWICE_MUST_BE_SYMBOL_NAME);
            }
        }
        return VALID;
    }

    private AnalyzerResponse containsLettersFromElementInOrder(String element, String symbol) {
        int firstCharacterLocation = element.indexOf(symbol.charAt(0));
        String restOfSequence = element.substring(firstCharacterLocation + 1);

        char secondCharOfSymbol = symbol.charAt(1);

        if (!restOfSequence.contains("" + secondCharOfSymbol))
            return
                element.contains("" + secondCharOfSymbol) ?
                    SYMBOL_LETTERS_NOT_IN_ORDER :
                    SYMBOL_LETTERS_NOT_ALL_FROM_CHEM_NAME;

        return VALID;
    }
}
