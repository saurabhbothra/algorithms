package com.algorithms.practice.tree;

public class SizeOfBinaryTree {

	// Given a binary tree, calculate its size.

	// efficient solution.
	public static int size(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + size(root.left) + size(root.right);
	}
}
