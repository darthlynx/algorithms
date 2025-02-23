package com.darthlynx.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        private Map<Integer, Integer> postorderMap = new HashMap<>();

        // Time complexity: O(n)
        // Space complexity: O(n)
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            for (int i = 0; i < postorder.length; i++) {
                postorderMap.put(postorder[i], i);
            }

            return constructSubTree(preorder, postorder, 0, 0, postorder.length - 1);
        }

        private TreeNode constructSubTree(int[] preorder, int[] postorder, int preIndex, int postStart, int postEnd) {
            if (preIndex >= preorder.length || postStart > postEnd) {
                return null;
            }

            if (postStart == postEnd) {
                return new TreeNode(postorder[postStart]);
            }

            // build the subtree root
            // first element in the preorder is always a root node of the current subtree
            TreeNode root = new TreeNode(preorder[preIndex]);

            // find the size of the left subtree
            if (preIndex + 1 < preorder.length) {
                int leftRootVal = preorder[preIndex + 1];
                int leftRootIndex = postorderMap.get(leftRootVal);

                int leftPostStart = postStart;
                int leftPostEnd = leftRootIndex;

                int rightPostStart = leftRootIndex + 1;
                int rightPostEnd = postEnd - 1;

                root.left = constructSubTree(preorder, postorder, preIndex + 1, leftPostStart, leftPostEnd);
                // left subtree size = leftPostEnd - leftPostStart + 1;
                int rightPreIndex = preIndex + (leftPostEnd - leftPostStart + 1) + 1;
                root.right = constructSubTree(preorder, postorder, rightPreIndex, rightPostStart, rightPostEnd);
            }
            return root;
        }
    }
}
