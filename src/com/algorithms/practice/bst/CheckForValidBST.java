package com.algorithms.practice.bst;

import com.algorithms.practice.tree.TreeNode;

public class CheckForValidBST {

	// Given the root of a binary tree, determine if it is a valid binary search
	// tree (BST).

	// A valid BST is defined as follows:

	// The left subtree of a node contains only nodes with keys less than the node's
	// key.
	// The right subtree of a node contains only nodes with keys greater than the
	// node's key.
	// Both the left and right subtrees must also be binary search trees.

	public Integer prev = null;

	// efficient solution, inorder traversal without extra space.
	public boolean isValidBSTInorder(TreeNode root) {
		if (root == null) {
			return true;
		}
		boolean isValidLeft = isValidBST(root.left);
		boolean isValidRoot = false;
		if (prev == null || prev < root.data) {
			prev = root.data;
			isValidRoot = true;
		}
		if (!isValidRoot) {
			return false;
		}
		boolean isValidRight = isValidBST(root.right);
		return isValidLeft && isValidRight;
	}
	
	// efficient solution.
	public boolean isValidBST(TreeNode root) {
		return isValidRec(root, null, null);
	}

	// helper method for doing recursion.
	public boolean isValidRec(TreeNode root, Integer currMin, Integer currMax) {
		if (root == null) {
			return true;
		}
		return (((currMin == null || root.data > currMin) && (currMax == null || root.data < currMax))
				&& isValidRec(root.left, currMin, root.data) && isValidRec(root.right, root.data, currMax));
	}

}
