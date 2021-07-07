package com.darthlynx.algorithms.algocademy.loops;

import org.junit.Test;

import static org.junit.Assert.*;

public class PairCountTest {

    @Test
    public void testPairCount() {
        int n = 7;
        int sum = 6;

        int expectedResult = 3;
        int actualResult = new PairCount().countPairs(n, sum);

        assertEquals(expectedResult, actualResult);
    }

}