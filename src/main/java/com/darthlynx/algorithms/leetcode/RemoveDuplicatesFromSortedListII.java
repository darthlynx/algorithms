package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
public class RemoveDuplicatesFromSortedListII {

    // sentinel head approach
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode(0); // dummy sentinel head. Value could be anything
        sentinel.next = head;

        ListNode prev = sentinel; // the previous node, that stores the pointer to the last node without duplicates

        while (head != null) {

            if (head.next != null && head.val == head.next.val) {
                // if curr value equals to the next value
                // skip all the nodes with this value from the list
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // point previous node's next pointer to the head.next
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = head.next;
        }

        return sentinel.next;
    }

}
