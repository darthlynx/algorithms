package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode merged = new ListNode(0); // empty node. Value might be anything
        ListNode result = merged; // stores the merged list head

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                merged.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                merged.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            merged = merged.next; // move to the next element of the merged list
        }

        // fulfill the merged list with the rest of the l1 list in case if l2 is finished already
        while (l1 != null) {
            merged.next = new ListNode(l1.val);
            l1 = l1.next;
            merged = merged.next; // move to the next element of the merged list
        }

        // fulfill the merged list with the rest of the l2 list in case if l1 is finished already
        while (l2 != null) {
            merged.next = new ListNode(l2.val);
            l2 = l2.next;
            merged = merged.next; // move to the next element of the merged list
        }

        return result.next;
    }
}
