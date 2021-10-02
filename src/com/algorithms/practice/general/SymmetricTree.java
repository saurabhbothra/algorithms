package com.algorithms.practice.general;

import com.algorithms.practice.tree.TreeNode;

// Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

public class SymmetricTree {

	// dfs solution.
	public boolean isSymmetric(TreeNode root) {
		return isSymmetricRec(root, root);
	}

	private boolean isSymmetricRec(TreeNode curr1, TreeNode curr2) {
		if (curr1 == null && curr2 == null) {
			return true;
		}

		if (curr1 == null || curr2 == null) {
			return false;
		}

		if (curr1.data != curr2.data) {
			return false;
		}

		return isSymmetricRec(curr1.left, curr2.right) && isSymmetricRec(curr1.right, curr2.left);
	}
}
