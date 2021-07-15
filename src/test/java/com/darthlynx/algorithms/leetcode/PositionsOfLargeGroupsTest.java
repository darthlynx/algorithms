package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PositionsOfLargeGroupsTest {

    private PositionsOfLargeGroups test = new PositionsOfLargeGroups();

    @Test
    public void testSimpleString() {

        String s = "aaa";

        List<List<Integer>> expectedResult = new ArrayList<>();
        expectedResult.add(List.of(0,2));

        List<List<Integer>> actualResult = test.largeGroupPositions(s);

        for (int i = 0; i < expectedResult.size(); i++) {
            assertEquals(expectedResult.get(i), actualResult.get(i));
        }
    }

    @Test
    public void testEmptyListOutput() {
        String s = "aa";

        List<List<Integer>> actualResult = test.largeGroupPositions(s);

        assertTrue(actualResult.isEmpty());
    }


    @Test
    public void testComplexString() {

        String s = "abcdddeeeeaabbbcd";

        List<List<Integer>> expectedResult = new ArrayList<>();
        expectedResult.add(List.of(3,5));
        expectedResult.add(List.of(6,9));
        expectedResult.add(List.of(12,14));

        List<List<Integer>> actualResult = test.largeGroupPositions(s);

        for (int i = 0; i < expectedResult.size(); i++) {
            assertEquals(expectedResult.get(i), actualResult.get(i));
        }
    }

    @Test
    public void testComplexStringWithoutLongSubsctrings() {
        String s = "bababbabaa";

        List<List<Integer>> actualResult = test.largeGroupPositions(s);
        assertTrue(actualResult.isEmpty());
    }
}