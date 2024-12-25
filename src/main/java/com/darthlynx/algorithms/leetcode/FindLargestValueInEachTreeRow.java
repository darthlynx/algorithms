package com.darthlynx.algorithms.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/find-largest-value-in-each-tree-row/
public class FindLargestValueInEachTreeRow {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Time complexity: O(N * logN)
    // Space complexity: O(N)
    class Solution1 {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            while (!q.isEmpty()) {
                int size = q.size();
                PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

                for (int i = 0; i < size; i++) {
                    TreeNode current = q.poll();
                    if (current != null) {
                        maxHeap.offer(current.val);
                        if (current.left != null) {
                            q.offer(current.left);
                        }
                        if (current.right != null) {
                            q.offer(current.right);
                        }
                    }
                }
                if (maxHeap.size() > 0) {
                    result.add(maxHeap.peek());
                }
            }

            return result;
        }
    }

    // Time complexity: O(N)
    // Space complexity: O(N)
    class Solution2 {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            if (root != null) {
                q.offer(root);
            }

            while (!q.isEmpty()) {
                int size = q.size();
                int maxValue = Integer.MIN_VALUE;
                for (int i = 0; i < size; i++) {
                    TreeNode current = q.poll();
                    maxValue = Math.max(current.val, maxValue);
                    if (current.left != null) {
                        q.offer(current.left);
                    }
                    if (current.right != null) {
                        q.offer(current.right);
                    }
                }
                result.add(maxValue);
            }

            return result;
        }
    }

}
