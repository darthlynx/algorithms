package com.darthlynx.algorithms.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DecodeAndEncodeTinyURLTest {

    private static final String TEST_URL = "https://leetcode.com/problems/encode-and-decode-tinyurl/";
    private DecodeAndEncodeTinyURL codec;

    @Before
    public void setUp() {
        codec = new DecodeAndEncodeTinyURL();
    }

    @Test
    public void testDecodeEncodeChain() {
        String actualResult = codec.decode(codec.encode(TEST_URL));

        assertEquals(TEST_URL, actualResult);
    }

    @Test
    public void testCreateUniqueId() {
        long id = 2556;
        String firstRun = codec.createBase62UniqueID(id);
        String secondRun = codec.createBase62UniqueID(id);

        assertEquals(firstRun, secondRun);
    }

    @Test
    public void testGetStorageIdByShortURL() {
        String shortURL = "Po";

        long expectedResult = 2556;
        long actualResult = codec.getStorageIdByShortURL(shortURL);

        assertEquals(expectedResult, actualResult);
    }



}