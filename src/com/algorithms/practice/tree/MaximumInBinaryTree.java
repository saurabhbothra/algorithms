package com.algorithms.practice.tree;

public class MaximumInBinaryTree {

	// Given a binary tree, find node with maximum value in it.

	// efficient solution.
	public static int maximumInBinaryTree(TreeNode root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int leftValue = maximumInBinaryTree(root.left);
		int rightValue = maximumInBinaryTree(root.right);
		return Math.max(Math.max(root.data, leftValue), rightValue);
	}
}
