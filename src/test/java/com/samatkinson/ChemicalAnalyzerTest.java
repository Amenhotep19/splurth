package com.samatkinson;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ChemicalAnalyzerTest {

    private final ChemicalAnalyzer chemicalAnalyzer = new ChemicalAnalyzer();

    @Test
    public void symbolMustContainTwoLetters() throws Exception {
        assertThat(chemicalAnalyzer.isValid("Born", "b"), is(false));
        assertThat(chemicalAnalyzer.isValid("Born", "bo"), is(true));
        assertThat(chemicalAnalyzer.isValid("Born", "bor"), is(false));
    }
    @Test
    public void analyzerIsCaseInsensitive() throws Exception {
        assertThat(chemicalAnalyzer.isValid("Carp", "Ca"), is(true));
        assertThat(chemicalAnalyzer.isValid("Carp", "ca"), is(true));
        assertThat(chemicalAnalyzer.isValid("Carp", "cA"), is(true));
        assertThat(chemicalAnalyzer.isValid("Carp", "CA"), is(true));
    }

    @Test
    public void symbolContainsOnlyLettersFromTheChemicalInOrder() throws Exception {
        assertThat(chemicalAnalyzer.isValid("Born", "bn"), is(true));
        assertThat(chemicalAnalyzer.isValid("Born", "rx"), is(false));
        assertThat(chemicalAnalyzer.isValid("Born", "no"), is(false));
    }
    @Test
    public void ifLetterAppearsTwiceNameMustBeThatLetterTwice() throws Exception {
        assertThat(chemicalAnalyzer.isValid("Boron", "oo"), is(true));
        assertThat(chemicalAnalyzer.isValid("Boron", "or"), is(false));
    }
}
