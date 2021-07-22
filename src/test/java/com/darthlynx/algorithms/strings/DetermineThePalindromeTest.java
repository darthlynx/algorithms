package com.darthlynx.algorithms.strings;

import org.junit.Test;

import static org.junit.Assert.*;

public class DetermineThePalindromeTest {

    private DetermineThePalindrome test = new DetermineThePalindrome();

    @Test
    public void testWordIsPalindromeAfterPermutationToReturnTrue() {
        String init = "carrace"; // can be rearranged to 'racecar'

        assertTrue(test.ifWordCanBeAPalindrome(init));
    }

    @Test
    public void testWordIsNotPalindromeToReturnFalse() {
        String init = "daily";

        assertFalse(test.ifWordCanBeAPalindrome(init));
    }

    @Test
    public void testWordConsistsOfEqualChars() {
        String init = "aaa";

        assertTrue(test.ifWordCanBeAPalindrome(init));
    }

}