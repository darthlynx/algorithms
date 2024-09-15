package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/invert-binary-tree/
public class InvertBinaryTree {
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
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            TreeNode tmp = root.right;
            root.right = invertTree(root.left);
            root.left = invertTree(tmp);
            return root;
        }
    }
}
