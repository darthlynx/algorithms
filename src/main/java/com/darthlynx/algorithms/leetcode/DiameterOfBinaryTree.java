package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/diameter-of-binary-tree/
public class DiameterOfBinaryTree {

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

        private int diameter = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            dfs(root);
            return diameter;
        }

        private int dfs(TreeNode node) {
            if (node == null) {
                return 0;
            }
            // diameter is a sum of heights of right and left branches
            int left = dfs(node.left);
            int right = dfs(node.right);

            diameter = Math.max(diameter, left + right);

            return 1 + Math.max(left, right);
        }
    }
}
