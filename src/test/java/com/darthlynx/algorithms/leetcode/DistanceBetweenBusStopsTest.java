package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class DistanceBetweenBusStopsTest {

    private DistanceBetweenBusStops test = new DistanceBetweenBusStops();

    @Test
    public void test1() {
        int[] distance = {1,2,3,4};
        int start = 0, destination = 1;

        int expectedResult = 1;
        int actualResult = test.distanceBetweenBusStops(distance, start, destination);

        assertEquals(expectedResult, actualResult);
    }


    @Test
    public void test2() {
        int[] distance = {7,10,1,12,11,14,5,0};
        int start = 7, destination = 2;

        int expectedResult = 17;
        int actualResult = test.distanceBetweenBusStops(distance, start, destination);

        assertEquals(expectedResult, actualResult);
    }
}