package com.darthlynx.algorithms.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumDepthOfBinaryTreeTest {

    @Test
    public void testMaxDepth() {
        MaximumDepthOfBinaryTree.TreeNode root = new MaximumDepthOfBinaryTree.TreeNode(1, null, new MaximumDepthOfBinaryTree.TreeNode(2));

        assertEquals(2, new MaximumDepthOfBinaryTree().maxDepth(root));
    }

}