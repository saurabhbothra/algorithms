package com.algorithms.practice.general;

import com.algorithms.practice.tree.TreeNode;

public class BinaryTreeMaximumPathSum {

	// A path in a binary tree is a sequence of nodes where each pair of adjacent
	// nodes in the sequence has an edge connecting them. A node can only appear in
	// the sequence at most once. Note that the path does not need to pass through
	// the root.

	// The path sum of a path is the sum of the node's values in the path.

	// Given the root of a binary tree, return the maximum path sum of any path.

	// recursive solution.
	public int maxSum = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		int ans = maxPathSumRec(root);
		return Math.max(maxSum, ans);
	}

	private int maxPathSumRec(TreeNode root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int leftSum = maxPathSumRec(root.left);
		int rightSum = maxPathSumRec(root.right);
		int sum = root.data;
		if (leftSum != Integer.MIN_VALUE) {
			sum += leftSum;
		}
		if (rightSum != Integer.MIN_VALUE) {
			sum += rightSum;
		}
		maxSum = Math.max(maxSum, Math.max(sum, Math.max(leftSum, rightSum)));
		int leftHalf = (leftSum == Integer.MIN_VALUE) ? root.data : root.data + leftSum;
		int rightHalf = (rightSum == Integer.MIN_VALUE) ? root.data : root.data + rightSum;
		return Math.max(root.data, Math.max(leftHalf, rightHalf));
	}

}
