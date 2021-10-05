package com.algorithms.practice.general;

import com.algorithms.practice.tree.TreeNode;

public class SubtreeOfAnotherTree {

	// Given the roots of two binary trees root and subRoot, return true if there is
	// a subtree of root with the same structure and node values of subRoot and
	// false otherwise.

	// A subtree of a binary tree tree is a tree that consists of a node in tree and
	// all of this node's descendants. The tree tree could also be considered as a
	// subtree of itself.

	// dfs solution.
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if (root == null && subRoot == null) {
			return true;
		}
		if (root == null) {
			return false;
		}
		if (root.data == subRoot.data) {
			if (checkSubTree(root, subRoot)) {
				return true;
			}
		}

		return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
	}

	private boolean checkSubTree(TreeNode root, TreeNode subRoot) {
		if (root == null && subRoot == null) {
			return true;
		}
		if (root == null || subRoot == null) {
			return false;
		}

		return root.data == subRoot.data && checkSubTree(root.left, subRoot.left)
				&& checkSubTree(root.right, subRoot.right);
	}

}
