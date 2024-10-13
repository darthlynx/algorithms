package com.darthlynx.algorithms.leetcode;

import java.util.PriorityQueue;

// https://leetcode.com/problems/merge-k-sorted-lists/description/
public class MergeKSortedLists {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode sentinel = new ListNode();
            ListNode head = sentinel;

            PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

            // add first nodes in the queue
            for (ListNode node : lists) {
                if (node != null) {
                    pq.offer(node);
                }
            }

            while (!pq.isEmpty()) {
                ListNode node = pq.poll(); // get smallest node
                if (node.next != null) {
                    pq.offer(node.next);
                }
                head.next = node;
                head = head.next;
            }

            return sentinel.next;
        }
    }
}
