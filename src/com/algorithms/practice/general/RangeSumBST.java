package com.algorithms.practice.general;

import com.algorithms.practice.tree.TreeNode;

public class RangeSumBST {

	// Given the root node of a binary search tree and two integers low and high,
	// return the sum of values of all nodes with a value in the inclusive range
	// [low, high].

	// All Node.data are unique.

	// efficient solution.
	public int rangeSumBST(TreeNode root, int low, int high) {
		if (root == null) {
			return 0;
		}
		if (low > high) {
			return 0;
		}
		int sum = 0;
		if (root.data < low) {
			sum = sum + rangeSumBST(root.right, low, high);
		} else if (root.data > high) {
			sum = sum + rangeSumBST(root.left, low, high);
		} else {
			sum = sum + root.data + rangeSumBST(root.left, low, root.data - 1)
					+ rangeSumBST(root.right, root.data + 1, high);
		}
		return sum;
	}

}
