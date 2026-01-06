package com.darthlynx.algorithms.leetcode;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
public class MaximumLevelSumOfABinaryTree {

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

        // Time complexity: O(n)
        // Space complexity: O(w), where w is the maximum width of the tree
        public int maxLevelSum(TreeNode root) {
            Queue<TreeNode> children = new LinkedList<>();
            children.add(root);

            int maxSum = Integer.MIN_VALUE;
            int level = 1;
            int maxSumLevel = level;

            while (!children.isEmpty()) {
                int size = children.size();
                int levelSum = 0;
                for (int i = 0; i < size; i++) {
                    TreeNode node = children.poll();
                    levelSum += node.val;
                    if (node.left != null) {
                        children.offer(node.left);
                    }
                    if (node.right != null) {
                        children.offer(node.right);
                    }
                }
                if (levelSum > maxSum) {
                    maxSum = levelSum;
                    maxSumLevel = level;
                }
                level++;
            }
            return maxSumLevel;
        }
    }
}
