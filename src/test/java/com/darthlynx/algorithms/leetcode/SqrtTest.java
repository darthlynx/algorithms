package com.darthlynx.algorithms.leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SqrtTest {

    private int number;
    private int expectedResult;
    private Sqrt test = new Sqrt();

    public SqrtTest(int number, int expectedResult) {
        this.number = number;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection parameters() {
        return Arrays.asList(new Object[][] {
                {5, 2},
                {2147395599, 46339},
                {2, 1},
                {4, 2},
                {8, 2},
                {0, 0},
                {1, 1},
                {9, 3},
                {Integer.MAX_VALUE, 46340}
        });
    }

    @Test
    public void testSqrt() {
        assertEquals(expectedResult, test.mySqrt(number));
    }

}