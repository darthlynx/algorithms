package com.darthlynx.algorithms.leetcode;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumNestingDepthOfTheParenthesesTest {

    private MaximumNestingDepthOfTheParentheses test = new MaximumNestingDepthOfTheParentheses();

    @Test
    public void testValidParentheses1() {
        String s = "";
        int expectedResult = 0;

        int actualResult = test.maxDepth(s);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testValidParentheses2() {
        String s = "()()";
        int expectedResult = 1;

        int actualResult = test.maxDepth(s);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testValidParentheses3() {
        String s = "()(()())";
        int expectedResult = 2;

        int actualResult = test.maxDepth(s);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testValidParentheses4() {
        String s = "(1+(2*3)+((8)/4))+1";
        int expectedResult = 3;

        int actualResult = test.maxDepth(s);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testValidParentheses5() {
        String s = "1+(2*3)/(2-1)";
        int expectedResult = 1;

        int actualResult = test.maxDepth(s);

        assertEquals(expectedResult, actualResult);
    }

    @Test @Ignore
    public void testNonValidParentheses1() {
        String s = ")(";
        int expectedResult = 0;

        int actualResult = test.maxDepth(s);

        assertEquals(expectedResult, actualResult);
    }

    @Test @Ignore
    public void testNonValidParentheses2() {
        String s = "(()";
        int expectedResult = 0;

        int actualResult = test.maxDepth(s);

        assertEquals(expectedResult, actualResult);
    }

}