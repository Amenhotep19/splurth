package com.samatkinson;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ChemicalAnalyzerTest {

    private final ChemicalAnalyzer chemicalAnalyzer = new ChemicalAnalyzer();

    @Test
    public void symbolMustContainTwoLetters() throws Exception {
        assertThat(chemicalAnalyzer.isValid("Born", "bo").valid, is(true));
        assertThat(chemicalAnalyzer.isValid("Born", "b").valid, is(false));
        assertThat(chemicalAnalyzer.isValid("Born", "bor").valid, is(false));
        assertThat(chemicalAnalyzer.isValid("Born", "bor").description,  is(AnalyzerResponse.SYMBOL_IS_NOT_TWO_LETTERS));
    }
    @Test
    public void analyzerIsCaseInsensitive() throws Exception {
        assertThat(chemicalAnalyzer.isValid("Carp", "Ca").valid, is(true));
        assertThat(chemicalAnalyzer.isValid("Carp", "ca").valid, is(true));
        assertThat(chemicalAnalyzer.isValid("Carp", "cA").valid, is(true));
        assertThat(chemicalAnalyzer.isValid("Carp", "CA").valid, is(true));
    }

    @Test
    public void symbolContainsOnlyLettersFromTheChemicalInOrder() throws Exception {
        assertThat(chemicalAnalyzer.isValid("Born", "bn").valid, is(true));
        assertThat(chemicalAnalyzer.isValid("Born", "rx").valid, is(false));
        assertThat(chemicalAnalyzer.isValid("Born", "rx").description,  is(AnalyzerResponse.SYMBOL_LETTERS_NOT_ALL_FROM_CHEM_NAME));

        assertThat(chemicalAnalyzer.isValid("Born", "no").valid, is(false));
        assertThat(chemicalAnalyzer.isValid("Born", "no").description,  is(AnalyzerResponse.SYMBOL_LETTERS_NOT_IN_ORDER));

    }
    @Test
    public void ifLetterAppearsTwiceNameMustBeThatLetterTwice() throws Exception {
        assertThat(chemicalAnalyzer.isValid("Boron", "oo").valid, is(true));
        assertThat(chemicalAnalyzer.isValid("Boron", "or").valid, is(false));
    }
}
