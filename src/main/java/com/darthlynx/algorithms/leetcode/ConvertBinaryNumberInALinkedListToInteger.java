package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
public class ConvertBinaryNumberInALinkedListToInteger {

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

        // Time complexity: O(n)
        // Space complexity: O(n)
        public int getDecimalValue(ListNode head) {
            StringBuilder builder = new StringBuilder();
            while (head != null) {
                builder.append(head.val);
                head = head.next;
            }
            return Integer.parseInt(builder.toString(), 2);
        }
    }
}
