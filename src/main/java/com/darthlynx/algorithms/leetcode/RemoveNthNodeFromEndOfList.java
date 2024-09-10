package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthNodeFromEndOfList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            int size = getListSize(head);

            ListNode sentinel = new ListNode(-1, head);
            ListNode prev = sentinel;
            ListNode current = head;

            int i = 1;
            while (i < size - n + 1) {
                prev = current;
                current = current.next;
                i++;
            }
            prev.next = current.next;

            return sentinel.next;
        }

        private int getListSize(ListNode head) {
            int size = 0;
            while (head != null) {
                size++;
                head = head.next;
            }
            return size;
        }
    }
}
