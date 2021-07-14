package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveAllAdjacentDuplicatesInStringTest {

    private RemoveAllAdjacentDuplicatesInString test = new RemoveAllAdjacentDuplicatesInString();

    @Test
    public void test1() {
        String s = "abbaca";
        String expectedResult = "ca";

        assertEquals(expectedResult, test.removeDuplicates(s));
    }

}