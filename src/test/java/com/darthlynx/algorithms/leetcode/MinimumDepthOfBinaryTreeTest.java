package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumDepthOfBinaryTreeTest {

    @Test
    public void testMinDepth() {
        MinimumDepthOfBinaryTree.TreeNode rRight = new MinimumDepthOfBinaryTree.TreeNode(20, new MinimumDepthOfBinaryTree.TreeNode(15), new MinimumDepthOfBinaryTree.TreeNode(7));
        MinimumDepthOfBinaryTree.TreeNode root = new MinimumDepthOfBinaryTree.TreeNode(3, null, rRight);

        assertEquals(3, new MinimumDepthOfBinaryTree().minDepth(root));
    }

    @Test
    public void testMinDepth2() {
        // [1,2,3,4,5]
        MinimumDepthOfBinaryTree.TreeNode rLeft = new MinimumDepthOfBinaryTree.TreeNode(2);
        MinimumDepthOfBinaryTree.TreeNode rRight = new MinimumDepthOfBinaryTree.TreeNode(3, new MinimumDepthOfBinaryTree.TreeNode(4), new MinimumDepthOfBinaryTree.TreeNode(5));
        MinimumDepthOfBinaryTree.TreeNode root = new MinimumDepthOfBinaryTree.TreeNode(1, rLeft, rRight);

        assertEquals(2, new MinimumDepthOfBinaryTree().minDepth(root));
    }

}