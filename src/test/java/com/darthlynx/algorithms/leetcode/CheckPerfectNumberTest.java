package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class CheckPerfectNumberTest {

    private final CheckPerfectNumber test = new CheckPerfectNumber();

    @Test
    public void testSmallPerfectNumber() {
        int num = 28;

        assertTrue(test.checkPerfectNumber(num));
    }

    @Test
    public void testSmallNonPerfectNumberToReturnFalse() {
        int num = 27;

        assertFalse(test.checkPerfectNumber(num));
    }

}