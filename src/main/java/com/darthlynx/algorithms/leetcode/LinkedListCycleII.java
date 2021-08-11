package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/linked-list-cycle-ii/
public class LinkedListCycleII {

    // explanation schema is in the src/main/resources/explanations/leetcode/LinkedListCycle.png
    public ListNode detectCycle(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode temp = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            // when we found that list has a cycle, we need to make small steps by two pointers
            // first one - slow from the previous iteration. It will reach the end of the list and comeback to the cycled node
            // second one - temp. It should make steps from the head of the list.
            // once they are met, we found the place where the cycle started.
            if (fast == slow) {
                while (temp != slow) {
                    temp = temp.next;
                    slow = slow.next;
                }
                return temp;
            }
        }

        return null;
    }
}
