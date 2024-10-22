package com.darthlynx.algorithms.leetcode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/
public class KthLargestSumInABinaryTree {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {

        // Time complexity: O(logN*logK), where K - size of the min heap
        // Space complexity: O(n)
        public long kthLargestLevelSum(TreeNode root, int k) {
            PriorityQueue<Long> minHeap = new PriorityQueue<>();

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            while (!q.isEmpty()) {
                int size = q.size();
                long sum = 0;
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    if (node == null) {
                        continue;
                    }
                    sum = sum + (long) node.val;
                    if (node.left != null) {
                        q.offer(node.left);
                    }
                    if (node.right != null) {
                        q.offer(node.right);
                    }
                }
                minHeap.offer(sum);
                while (minHeap.size() > k) {
                    minHeap.poll();
                }
            }

            return minHeap.size() < k ? -1 : minHeap.peek();
        }
    }
}
