package com.darthlynx.algorithms.arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class MoreThanOneDuplicateInTheStringTest {

    private final String expectedTrue = "aaabb";
    private final String expectedFalse = "aabbcc";

    @Test
    public void testMoreThanOneDupIsTrueForMapApproach() {
        boolean result = MoreThanOneDuplicateInTheString.isHasMoreThanOneDup(expectedTrue);

        assertTrue(result);
    }

    @Test
    public void testMoreThanOneDupIsFalseForMapApproach() {
        boolean result = MoreThanOneDuplicateInTheString.isHasMoreThanOneDup(expectedFalse);

        assertFalse(result);
    }

    @Test
    public void testMoreThanOneDupIsTrueForArrayApproach() {
        boolean result = MoreThanOneDuplicateInTheString.hasMoreDups(expectedTrue);

        assertTrue(result);
    }

    @Test
    public void testMoreThanOneDupIsFalseForArrayApproach() {
        boolean result = MoreThanOneDuplicateInTheString.hasMoreDups(expectedFalse);

        assertFalse(result);
    }


}