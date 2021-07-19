package com.darthlynx.algorithms.leetcode;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LetterCombinationsOfAPhoneNumberTest {

    private LetterCombinationsOfAPhoneNumber test;

    @Before
    public void setUp() {
        test = new LetterCombinationsOfAPhoneNumber();
    }

    @Test
    public void testLetterCombinationsForTwoDigits() {
        String digits = "23";
        List<String> expectedResult = List.of("ad","ae","af","bd","be","bf","cd","ce","cf");

        List<String> actualResult = test.letterCombinations(digits);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testLetterCombinationsForEmptyDigits() {
        String digits = "";

        List<String> actualResult = test.letterCombinations(digits);

        assertTrue(actualResult.isEmpty());
    }

    @Test
    public void testLetterCombinationsForSingleDigit() {
        String digits = "2";
        List<String> expectedResult = List.of("a","b","c");

        List<String> actualResult = test.letterCombinations(digits);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testLetterCombinationsForThreeDigits() {
        String digits = "234";
        List<String> expectedResult = List.of("adg","adh","adi","aeg","aeh","aei","afg","afh","afi","bdg","bdh","bdi","beg","beh","bei","bfg","bfh","bfi","cdg","cdh","cdi","ceg","ceh","cei","cfg","cfh","cfi");

        List<String> actualResult = test.letterCombinations(digits);

        assertEquals(expectedResult, actualResult);
    }

}