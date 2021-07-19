package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseVowelsOfStringTest {

    private ReverseVowelsOfString test = new ReverseVowelsOfString();

    @Test
    public void testLeetcodeString() {
        String input = "leetcode";
        String expectedResult = "leotcede";

        String actualResult = test.reverseVowels(input);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testShortWordConsistsOfVowels() {
        String input = "aA";
        String expectedResult = "Aa";

        String actualResult = test.reverseVowels(input);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testStringWithSpaceInside() {
        String input = "race car";
        String expectedResult = "race car";

        String actualResult = test.reverseVowels(input);

        assertEquals(expectedResult, actualResult);
    }


}