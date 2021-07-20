package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveAllOccurrencesOfASubstringTest {

    private RemoveAllOccurrencesOfASubstring test = new RemoveAllOccurrencesOfASubstring();

    @Test
    public void testRemoveOccurrence() {
        String s = "daabcbaabcbc";
        String part = "abc";

        String expectedResult = "dab";

        String actualResult = test.removeOccurrences(s, part);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testRemoveOccurrence2() {
        String s = "axxxxyyyyb";
        String part = "xy";

        String expectedResult = "ab";

        String actualResult = test.removeOccurrences(s, part);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testRemoveOccurrenceOfCharInStringOfSameChars() {
        String s = "aaaaa";
        String part = "a";

        String expectedResult = "";

        String actualResult = test.removeOccurrences(s, part);

        assertEquals(expectedResult, actualResult);
    }

}