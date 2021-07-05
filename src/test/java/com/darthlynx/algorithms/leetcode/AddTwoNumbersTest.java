package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddTwoNumbersTest {

    @Test
    public void testAddTwoNumbers() {
        AddTwoNumbers test = new AddTwoNumbers();
        ListNode list1 = constructLinkedList(243);
        ListNode list2 = constructLinkedList(564);

        int expectedResultSet = 708;
        ListNode result = test.addTwoNumbers(list1, list2);
        int actualResult = toInt(result);

        assertEquals(expectedResultSet, actualResult);
    }



    class UnidirectionalLinkedList {
        private ListNode head;

        UnidirectionalLinkedList() {}

        public void append(int value) {
            ListNode node = new ListNode(value);
            if (head == null) {
                head = node;
            } else {
                ListNode currentNode = head;
                while (currentNode.next != null) {
                    currentNode = currentNode.next;
                }
                currentNode.next = node;
            }
        }

        public ListNode getHead() {
            return head;
        }
    }

    private ListNode constructLinkedList(int number) {
        UnidirectionalLinkedList linkedList = new UnidirectionalLinkedList();

        for (char elem : String.valueOf(number).toCharArray()) {
            linkedList.append(Integer.parseInt(String.valueOf(elem)));
        }
        return linkedList.getHead();
    }

    private int toInt(ListNode head) {
        StringBuilder builder = new StringBuilder();
        ListNode current = head;
        while (current != null) {
            builder.append(current.val);
            current = current.next;
        }
        return Integer.parseInt(builder.toString());
    }

}