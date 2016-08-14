package com.samatkinson;

import org.junit.Test;

import static com.samatkinson.AnalyzerResponse.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ChemicalAnalyzerTest {

    private final ChemicalAnalyzer chemicalAnalyzer = new ChemicalAnalyzer();

    @Test
    public void symbolMustContainTwoLetters() throws Exception {
        assertThat(chemicalAnalyzer.isValid("Born", "bo"), is(VALID));
        assertThat(chemicalAnalyzer.isValid("Born", "b"), is(SYMBOL_IS_NOT_TWO_LETTERS));
        assertThat(chemicalAnalyzer.isValid("Born", "bor"),  is(SYMBOL_IS_NOT_TWO_LETTERS));
    }
    @Test
    public void analyzerIsCaseInsensitive() throws Exception {
        assertThat(chemicalAnalyzer.isValid("Carp", "Ca"), is(VALID));
        assertThat(chemicalAnalyzer.isValid("Carp", "ca"), is(VALID));
        assertThat(chemicalAnalyzer.isValid("Carp", "cA"), is(VALID));
        assertThat(chemicalAnalyzer.isValid("Carp", "CA"), is(VALID));
    }

    @Test
    public void symbolContainsOnlyLettersFromTheChemicalInOrder() throws Exception {
        assertThat(chemicalAnalyzer.isValid("Born", "bn"), is(VALID));
        assertThat(chemicalAnalyzer.isValid("Born", "rx"),  is(SYMBOL_LETTERS_NOT_ALL_FROM_CHEM_NAME));

        assertThat(chemicalAnalyzer.isValid("Born", "no"),  is(SYMBOL_LETTERS_NOT_IN_ORDER));

    }

    @Test
    public void ifLetterAppearsTwiceNameMustBeThatLetterTwice() throws Exception {
        assertThat(chemicalAnalyzer.isValid("Boron", "oo"), is(VALID));
        assertThat(chemicalAnalyzer.isValid("Boron", "or"), is(IF_LETTER_OCCURS_TWICE_MUST_BE_SYMBOL_NAME));
    }
}
