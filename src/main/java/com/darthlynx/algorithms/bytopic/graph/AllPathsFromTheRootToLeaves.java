package com.darthlynx.algorithms.bytopic.graph;

import java.util.ArrayList;
import java.util.List;

// Given a binary tree, return all paths from the root to leaves.
// For example, given the tree:
//
//   1
//  / \
// 2   3
//    / \
//   4   5
//
// Return [[1, 2], [1, 3, 4], [1, 3, 5]].
public class AllPathsFromTheRootToLeaves {

    public static void main(String []args){
        TreeNode root = getTree();
        List<List<Integer>> result = getBinaryTreePaths(root);

        System.out.println(result);
    }

    private static List<List<Integer>> paths = new ArrayList<>();

    public static List<List<Integer>> getBinaryTreePaths(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        dfs(root, path);
        return paths;
    }

    public static void dfs(TreeNode node, List<Integer> path) {
        if (node == null) {
            return;
        }

        List<Integer> p = new ArrayList<>(path);
        p.add(node.value);

        if (node.left == null && node.right == null) {
            paths.add(p);
        } else {
            dfs(node.left, p);
            dfs(node.right, p);
        }
    }

    public static TreeNode getTree() {
        TreeNode root = new TreeNode();
        root.left = new TreeNode(null, null, 2);
        root.right = new TreeNode(new TreeNode(null, null, 4), new TreeNode(null, null, 5), 3);
        root.value = 1;

        return root;
    }

    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        public TreeNode() {}

        public TreeNode(TreeNode left, TreeNode right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }
}
