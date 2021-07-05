package com.darthlynx.algorithms.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddBinaryTest {

    private AddBinary test = new AddBinary();

    @Test
    public void testAddSmallBinary() {
        String expectedResult = "100";

        String actualResult = test.addBinary("11", "1");

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testLargeBinaries() {
        String expectedResult = "110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000";

        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";

        String actualResult = test.addBinary(a, b);

        assertEquals(expectedResult, actualResult);
    }

}