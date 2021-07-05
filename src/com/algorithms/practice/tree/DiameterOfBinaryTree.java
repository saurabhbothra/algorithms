package com.algorithms.practice.tree;

public class DiameterOfBinaryTree {

	// Given the root of a binary tree, return the length of the diameter of the
	// tree.

	// The diameter of a binary tree is the length of the longest path between any
	// two nodes in a tree. This path may or may not pass through the root.

	// The length of a path between two nodes is represented by the number of edges
	// between them.

	public int maxDiameter = 0;

	// efficient solution.
	public int diameterOfBinaryTree(TreeNode root) {
		diameter(root);
		return maxDiameter;
	}

	// helper method for doing recursion.
	public int diameter(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftValue = diameter(root.left);
		int rightValue = diameter(root.right);
		maxDiameter = Math.max(maxDiameter, leftValue + rightValue);
		return 1 + Math.max(leftValue, rightValue);
	}

}
