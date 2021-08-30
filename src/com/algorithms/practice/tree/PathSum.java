package com.algorithms.practice.tree;

public class PathSum {

	// Given the root of a binary tree and an integer targetSum, return true if the
	// tree has a root-to-leaf path such that adding up all the values along the
	// path equals targetSum.

	// A leaf is a node with no children.

	// efficient recursive solution.
	public boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null) {
			return (targetSum - root.data) == 0;
		}
		return hasPathSum(root.left, targetSum - root.data) || hasPathSum(root.right, targetSum - root.data);
	}

}
