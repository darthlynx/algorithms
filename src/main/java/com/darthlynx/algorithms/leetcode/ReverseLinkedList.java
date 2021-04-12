package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

// https://leetcode.com/problems/reverse-linked-list
public class ReverseLinkedList {

     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }

         @Override
         public String toString() {
             return String.valueOf(this.val);
         }

     }

    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public ListNode reverseListRecursive(ListNode node) {
         if (node == null) {
             return null;
         }
         if (node.next == null) {
             return node;
         }
         ListNode current = reverseListRecursive(node.next);
         node.next.next = node;
         node.next = null;
         return current;
    }

    @Test
    public void testConstructLinkedList() {
        ListNode head = constructLinkedList();
        ListNode node = head;
        for (int i = 1; i <= 5; i++) {
            assertNotNull(node);
            assertEquals(i, node.val);
            node = node.next;
        }
    }

    @Test
    public void testReverseListRecursive() {
        ListNode head = constructLinkedList();
        ListNode node = head;

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
        ListNode head = constructLinkedList();
        ListNode node = head;

        ReverseLinkedList reversal = new ReverseLinkedList();
        node = reversal.reverseList(head);
        for (int i = 5; i >= 1; i--) {
            assertNotNull(node);
            assertEquals(i, node.val);
            node = node.next;
        }
    }

    private void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    private ListNode constructLinkedList() {
         ListNode head = null;
         ListNode tail = null;

         for (int i = 1; i <= 5; i++) {
             ListNode node = new ListNode(i);
             if (head == null) {
                 head = node;
             } else {
                 tail.next = node;
             }
             tail = node;
         }
         return head;
    }
}
