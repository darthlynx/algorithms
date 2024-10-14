package com.darthlynx.algorithms.leetcode;

import org.junit.Test;
import java.util.Arrays;

import static org.junit.Assert.*;

public class MinimumIndexSumOfTwoListsTest {

    private MinimumIndexSumOfTwoLists test = new MinimumIndexSumOfTwoLists();

    @Test
    public void test1() {
        String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = {"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};

        String[] expectedResult = {"Shogun"};

        String[] actualResult = test.findRestaurant(list1, list2);

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void test2() {
        String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = {"KFC","Shogun","Burger King"};

        String[] expectedResult = {"Shogun"};

        String[] actualResult = test.findRestaurant(list1, list2);

        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void test3() {
        String[] list1 = {"happy", "sad", "good"};
        String[] list2 = {"sad", "happy", "good"};

        String[] expectedResult = {"sad", "happy"};

        String[] actualResult = test.findRestaurant(list1, list2);

        assertTrue(Arrays.asList(expectedResult).containsAll(Arrays.asList(actualResult)));
    }

    @Test
    public void test4() {
        String[] list1 = {"KFC"};
        String[] list2 = {"KFC"};

        String[] expectedResult = {"KFC"};

        String[] actualResult = test.findRestaurant(list1, list2);

        assertArrayEquals(expectedResult, actualResult);
    }

}