package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class RepeatedSubstringPatternTest {

    private RepeatedSubstringPattern test = new RepeatedSubstringPattern();

    @Test
    public void testFindRepeatedStringInStringConsistsOfOneChar() {
        String input = "a";

        assertFalse(test.repeatedSubstringPattern(input));
    }

    @Test
    public void testFindRepeatedString() {
        String input = "abab";

        assertTrue(test.repeatedSubstringPattern(input));
    }

    @Test
    public void testReturnFalseForNonRepeatableSubstring() {
        String input = "aba";

        assertFalse(test.repeatedSubstringPattern(input));
    }



}