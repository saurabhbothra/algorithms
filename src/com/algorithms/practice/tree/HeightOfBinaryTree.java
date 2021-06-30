package com.algorithms.practice.tree;

public class HeightOfBinaryTree {

	// Given a binary tree, find its height.
	// Height of the binary tree is he number of nodes between the longest path from
	// root to leaf node.

	// efficient solution.
	public static int heightOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(heightOfBinaryTree(root.left), heightOfBinaryTree(root.right));
	}
}
