package com.darthlynx.algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/linked-list-cycle/
public class LinkedListCycle {

    // slow implementation
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> checkedNodes = new HashSet<>();

        ListNode currentNode = head;
        boolean isCycled = false;


        while (currentNode != null) {
            if (checkedNodes.contains(currentNode)) {
                isCycled = true;
                break;
            } else {
                checkedNodes.add(currentNode);
                currentNode = currentNode.next;
            }
        }

        return isCycled;

    }

    // two pointers implementation
    public boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        // fast pointer making two steps at one time, while the slow one making only one.
        // in case we have a cycle, the fast pointer will reach the slow one soon
        // if there are no cycles, we will reach the end of the least (where node.next == null)
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
