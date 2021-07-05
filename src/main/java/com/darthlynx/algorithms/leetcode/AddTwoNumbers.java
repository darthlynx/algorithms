package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {

    class ResultList {
        private ListNode head;
        private ListNode tail;

        public ResultList() {
            this.head = new ListNode();
            this.tail = head;
        }

        public void append(int value) {
            ListNode node = new ListNode(value);
            this.tail.next = node;
            this.tail = node;
        }
        public ListNode getHead() {
            return head;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ResultList result = new ResultList();
        ListNode p1 = l1;
        ListNode p2 = l2;
        int pointer = 0;

        while (p1 != null || p2 != null) {
            int x = (p1 != null) ? p1.val : 0;
            int y = (p2 != null) ? p2.val : 0;
            int sum = pointer + x + y;
            pointer = sum / 10;
            result.append(sum % 10);

            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }

        }

        if (pointer > 0) {
            result.append(pointer);
        }

        return result.getHead().next;
    }

}
