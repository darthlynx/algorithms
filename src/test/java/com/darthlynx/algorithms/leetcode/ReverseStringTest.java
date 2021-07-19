package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseStringTest {

    private ReverseString test = new ReverseString();

    @Test
    public void testReverseString1() {
        char[] initial = {'H','a','n','n','a','h'};
        char[] expectedResult = {'h','a','n','n','a','H'};

        test.reverseString(initial);
        assertArrayEquals(expectedResult, initial);
    }

    @Test
    public void testHello() {
        char[] initial = {'h','e','l','l','o'};
        char[] expectedResult = {'o','l','l','e','h'};

        test.reverseString(initial);

        assertArrayEquals(expectedResult, initial);
    }

}