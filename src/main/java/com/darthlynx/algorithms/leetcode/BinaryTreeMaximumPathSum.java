package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/binary-tree-maximum-path-sum/
public class BinaryTreeMaximumPathSum {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // we need to compare the result of both branches with 0
        // if they lower than 0, we should not take them into account
        // otherwise sum will be lower
        int left = Math.max(dfs(node.left), 0);
        int right = Math.max(dfs(node.right), 0);

        maxSum = Math.max(maxSum, left + right + node.val);

        return Math.max(left, right) + node.val;
    }
}
