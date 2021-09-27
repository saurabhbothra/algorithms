package com.algorithms.practice.tree;

import java.util.ArrayDeque;

public class ChildrenSumProperty {

	// Children Sum Property is a property in which the sum of values of the left
	// child and right child should be equal to the value of their node if both
	// children are present. Else if only one child is present then the value of the
	// child should be equal to its node value.

	// write a function that takes the root node as a parameter and returns 1 if
	// the Tree follows C.S.P. and 0 if the Tree does not follow C.S.P.

	// recursive solution.
	public static int isSumProperty(TreeNode root) {
		if (root == null) {
			return 1;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		int sum = 0;
		if (root.left != null) {
			sum += root.left.data;
		}
		if (root.right != null) {
			sum += root.right.data;
		}
		int leftVal = isSumProperty(root.left);
		int rightVal = isSumProperty(root.right);
		if ((leftVal == 1 && rightVal == 1) && (sum == root.data)) {
			return 1;
		}
		return 0;
	}

	// iterative solution.
	public static int isSumPropertyIter(TreeNode root) {
		ArrayDeque<TreeNode> q = new ArrayDeque<>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode poppedNode = q.poll();
			if (poppedNode.left == null && poppedNode.right == null) {
				continue;
			}
			int sum = 0;
			if (poppedNode.left != null) {
				sum += poppedNode.left.data;
				q.offer(poppedNode.left);
			}

			if (poppedNode.right != null) {
				sum += poppedNode.right.data;
				q.offer(poppedNode.right);
			}

			if (sum != poppedNode.data) {
				return 0;
			}
		}
		return 1;
	}

}
