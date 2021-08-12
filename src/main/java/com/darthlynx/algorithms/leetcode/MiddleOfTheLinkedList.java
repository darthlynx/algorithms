package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/middle-of-the-linked-list/
public class MiddleOfTheLinkedList {

    // TC: O(n)
    // SC: O(1)
    public ListNode middleNode(ListNode head) {

        // two pointers approach
        ListNode slow = head;
        ListNode fast = head;

        // since fast pointer making 2x steps than the slow one
        // it will reach the end of the list
        // when the slow one will be in the middle of the list
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
