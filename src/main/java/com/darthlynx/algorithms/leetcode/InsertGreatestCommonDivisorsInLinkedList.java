package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/
public class InsertGreatestCommonDivisorsInLinkedList {
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
        public ListNode insertGreatestCommonDivisors(ListNode head) {
            ListNode sentinel = new ListNode(-1, head);
            ListNode current = sentinel.next;

            while (current.next != null) {
                int gcd = gcd(current.val, current.next.val);
                ListNode mid = new ListNode(gcd, current.next);
                current.next = mid;
                current = current.next.next;
            }
            return sentinel.next;
        }

        private int gcd(int small, int large) {
            if (small == 0) {
                return large;
            }
            return gcd(large % small, small);
        }
    }
}
