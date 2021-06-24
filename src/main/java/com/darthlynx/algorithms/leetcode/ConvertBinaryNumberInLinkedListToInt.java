package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
public class ConvertBinaryNumberInLinkedListToInt {

    // fastest approach
    public int getDecimalValue(ListNode head) {

        StringBuilder builder = new StringBuilder();
        ListNode current = head;
        while (current != null) {
            builder.append(current.val);
            current = current.next;
        }

        return Integer.parseInt(builder.toString(), 2);
    }

    // slower, but uses less memory
    public int getDecimalValue2(ListNode head) {

        StringBuilder binarySequence = getBinarySequence(head);

        int power = binarySequence.length() - 1;

        int result = 0;
        for (int i = 0; i < binarySequence.length(); i++) {
            result += Character.getNumericValue(binarySequence.charAt(i)) * Math.pow(2, power);
            power--;
        }

        return result;
    }

    private StringBuilder getBinarySequence(ListNode node) {
        StringBuilder builder = new StringBuilder();

        ListNode current = node;
        while (current != null) {
            builder.append(current.val);
            current = current.next;
        }
        System.out.println(builder);
        return builder;
    }

    public class ListNode {
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
