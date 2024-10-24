package com.darthlynx.algorithms.leetcode;

// https://leetcode.com/problems/flip-equivalent-binary-trees/
public class FlipEquivalentBinaryTrees {

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

        // It is important to understand that we don't need to flip entire tree!
        // we just need to flip some nodes to make trees equivalent
        //
        // Time complexity: O(n) for unbalanced tree or O(logN) for balanced tree
        // Space complexity: O(n) - using stack for recursion
        public boolean flipEquiv(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) {
                return true;
            }
            if (root1 == null || root2 == null) {
                return false;
            }
            if (root1.val != root2.val) {
                return false;
            }
            
            // check if subtrees are equal without flipping
            boolean noFlip = flipEquiv(root1.left, root2.left) &&
                             flipEquiv(root1.right, root2.right);
            
            // check if they become equal after flipping
            boolean flip = flipEquiv(root1.left, root2.right) &&
                           flipEquiv(root1.right, root2.left);
            
            // if either one or another works, trees are "fleep equivalent"
            return noFlip || flip;
        }
    }
}
