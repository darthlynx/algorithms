package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class DecryptStringFromAlphabetToIntegerMappingTest {

    private final DecryptStringFromAlphabetToIntegerMapping test = new DecryptStringFromAlphabetToIntegerMapping();

    @Test
    public void testSimpleDecryption() {
        String s = "10#11#12";
        String expectedResult = "jkab";

        String actualResult = test.freqAlphabets(s);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testStringWithNumberSignInTheEnd() {
        String s = "10#";
        String expectedResult = "j";

        String actualResult = test.freqAlphabets(s);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testAlphabet() {
        String s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#";
        String expectedResult = "abcdefghijklmnopqrstuvwxyz";

        String actualResult = test.freqAlphabets(s);

        assertEquals(expectedResult, actualResult);
    }

}