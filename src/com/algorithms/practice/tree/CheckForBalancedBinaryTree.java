package com.algorithms.practice.tree;

public class CheckForBalancedBinaryTree {

	// Given a binary tree, determine if it is height-balanced.
	// For this problem, a height-balanced binary tree is defined as:
	// a binary tree in which the left and right subtrees of every node differ in
	// height by no more than 1.

	// naive solution.
	public static boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		int leftHeight = heightOfBinaryTree(root.left);
		int rightHeight = heightOfBinaryTree(root.right);
		int diff = Math.abs(leftHeight - rightHeight);
		if (diff <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
			return true;
		}
		return false;
	}

	// helper method to find height of binary tree.
	public static int heightOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(heightOfBinaryTree(root.left), heightOfBinaryTree(root.right));
	}

	// efficient solution.
	public static boolean isBalancedEfficient(TreeNode root) {
		if (root == null) {
			return true;
		}
		int result = heightOfBinaryTreeRec(root);
		return (result == -1) ? false : true;
	}

	// helper method to find height and validate for balanced tree.
	public static int heightOfBinaryTreeRec(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = heightOfBinaryTreeRec(root.left);
		if (leftHeight == -1) {
			return -1;
		}
		int rightHeight = heightOfBinaryTreeRec(root.right);
		if (rightHeight == -1) {
			return -1;
		}
		int diff = Math.abs(leftHeight - rightHeight);
		if (diff > 1) {
			return -1;
		}
		return 1 + Math.max(leftHeight, rightHeight);
	}
}
