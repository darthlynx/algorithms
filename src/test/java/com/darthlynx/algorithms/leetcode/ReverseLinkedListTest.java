package com.darthlynx.algorithms.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseLinkedListTest {

    ReverseLinkedList.ListNode head;

    @Before
    public void setUp() {
        head = new ReverseLinkedList().constructLinkedList();
    }

    @Test
    public void testConstructLinkedList() {
        ReverseLinkedList.ListNode node = head;
        for (int i = 1; i <= 5; i++) {
            assertNotNull(node);
            assertEquals(i, node.val);
            node = node.next;
        }
    }

    @Test
    public void testReverseListRecursive() {
        ReverseLinkedList.ListNode node = head;

        ReverseLinkedList reversal = new ReverseLinkedList();
        node = reversal.reverseListRecursive(head);
        for (int i = 5; i >= 1; i--) {
            assertNotNull(node);
            assertEquals(i, node.val);
            node = node.next;
        }

    }

    @Test
    public void testReverseList() {
        ReverseLinkedList.ListNode node = head;

        ReverseLinkedList reversal = new ReverseLinkedList();
        node = reversal.reverseList(head);
        for (int i = 5; i >= 1; i--) {
            assertNotNull(node);
            assertEquals(i, node.val);
            node = node.next;
        }
    }

}