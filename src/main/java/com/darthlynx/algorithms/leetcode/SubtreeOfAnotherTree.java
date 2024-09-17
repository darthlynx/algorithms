package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/subtree-of-another-tree/
public class SubtreeOfAnotherTree {

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
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if (subRoot == null) {
                return true;
            }
            if (root == null) {
                return false;
            }

            if (isSameTree(root, subRoot)) {
                return true;
            }

            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        private boolean isSameTree(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) {
                return true;
            }

            if (t1 != null && t2 != null && t1.val == t2.val) {
                return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
            }

            return false;
        }
    }

}
