package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/balanced-binary-tree/
public class BalancedBinaryTree {

    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        getHeight(root);
        return isBalanced;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return Math.max(left, right) + 1;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
