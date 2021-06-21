package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/path-sum/
public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }

    public boolean dfs(TreeNode node, int currentSum, int targetSum) {
        if (node == null) {
            return false;
        }

        currentSum += node.val;

        if (isLeafNode(node)) {
            return currentSum == targetSum;
        }

        return dfs(node.left, currentSum, targetSum) ||
               dfs(node.right, currentSum, targetSum);
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
