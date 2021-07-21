package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class ToLowerCaseTest {

    private ToLowerCase test = new ToLowerCase();

    @Test
    public void testToLowerCase() {
        String input = "Hello";
        String expectedResult = "hello";

        String actualResult = test.toLowerCase(input);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testLastCharInTheAlphabet() {
        String input = "ZEBRA";
        String expectedResult = "zebra";

        String actualResult = test.toLowerCase(input);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFirstCharInTheAlphabet() {
        String input = "AA";
        String expectedResult = "aa";

        String actualResult = test.toLowerCase(input);
        assertEquals(expectedResult, actualResult);
    }

}