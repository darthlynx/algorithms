package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/palindrome-linked-list/
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }

        // finding the middle of the LinkedList
        ListNode middle = middleNode(head);
        // reverting the second part of the list (starting from the middle)
        ListNode reverse = reverseList(middle);

        // compare head and reverse value by value to make sure, that list is a palindrome
        while (reverse != null && head != null) {
            if (reverse.val != head.val) {
                return false;
            }
            reverse = reverse.next;
            head = head.next;
        }
        return true;
    }

    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
