package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/remove-linked-list-elements/
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {

        ListNode current = head;

        while (current != null) {
            if (current.val == val) {
                head = current.next;
                current = head;
            } else if (current.next != null && current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
