package com.algorithms.practice.tree;

public class SumRootToLeafNumbers {

	// You are given the root of a binary tree containing digits from 0 to 9 only.

	// Each root-to-leaf path in the tree represents a number.

	// For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
	// Return the total sum of all root-to-leaf numbers. Test cases are generated so
	// that the answer will fit in a 32-bit integer.

	// A leaf node is a node with no children.

	// dfs solution.

	public int sum = 0;

	public int sumNumbers(TreeNode root) {
		sumRec(root, 0);
		return sum;
	}

	private void sumRec(TreeNode root, int x) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			sum += x + root.data;
			return;
		}
		if (root.left != null) {
			sumRec(root.left, (x + root.data) * 10);
		}
		if (root.right != null) {
			sumRec(root.right, (x + root.data) * 10);
		}
	}

}
