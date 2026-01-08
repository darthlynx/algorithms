package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
public class MaximumProductOfSplittedBinaryTree {

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

        private long maxProductVal = 0;
        private static int modulo = 1_000_000_007;

        // Time complexity: O(n)
        // Space complexity: O(h), where h is the height of the tree
        public int maxProduct(TreeNode root) {
            long total = totalSum(root);
            dfs(root, total);
            return (int) (maxProductVal % modulo);
        }

        private long dfs(TreeNode root, long totalSum) {
            if (root == null) {
                return 0l;
            }

            long subtreeSum = root.val
                    + dfs(root.left, totalSum)
                    + dfs(root.right, totalSum);

            long product = (totalSum - subtreeSum) * subtreeSum;
            if (product > maxProductVal) {
                maxProductVal = product;
            }

            return subtreeSum;
        }

        private long totalSum(TreeNode root) {
            if (root == null) {
                return 0l;
            }

            return root.val + totalSum(root.left) + totalSum(root.right);
        }
    }
}
