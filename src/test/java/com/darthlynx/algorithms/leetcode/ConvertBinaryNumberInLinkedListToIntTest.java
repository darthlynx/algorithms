package com.darthlynx.algorithms.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConvertBinaryNumberInLinkedListToIntTest {

    private ConvertBinaryNumberInLinkedListToInt converter;

    @Before
    public void setUp() {
        converter = new ConvertBinaryNumberInLinkedListToInt();
    }

    @Test
    public void testConvertZero() {
        ConvertBinaryNumberInLinkedListToInt.ListNode head = converter.new ListNode(0, null);

        int expectedResult = 0;
        int actualResult = converter.getDecimalValue(head);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testConvertOne() {
        ConvertBinaryNumberInLinkedListToInt.ListNode node2 = converter.new ListNode(1, null);
        ConvertBinaryNumberInLinkedListToInt.ListNode node1 = converter.new ListNode(0, node2);
        ConvertBinaryNumberInLinkedListToInt.ListNode head = converter.new ListNode(1, node1);

        int expectedResult = 5;
        int actualResult = converter.getDecimalValue(head);

        assertEquals(expectedResult, actualResult);

    }

}