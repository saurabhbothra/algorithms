package com.algorithms.practice.tree;

public class CountNodesInCompleteBinaryTree {

	// Given the root of a complete binary tree, return the number of the nodes in
	// the tree.

	// Every level, except possibly the last, is completely filled in a complete
	// binary tree, and all nodes in the last level are as far left as possible. It
	// can have between 1 and 2h nodes inclusive at the last level h.

	// Design an algorithm that runs in less than O(n) time complexity.

	// The tree is guaranteed to be complete.

	public int actualLevel = 0;

	// naive solution.
	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftCount = countNodes(root.left);
		int rightCount = countNodes(root.right);
		return 1 + leftCount + rightCount;
	}

	// efficient solution.
	public int countNodesIterative(TreeNode root) {
		if (root == null) {
			return 0;
		}
		actualLevel = computeDepth(root);
		return getCount(root);
	}

	// helper method to find total nodes in binary tree.
	public int getCount(TreeNode root) {
		int nodeIndex = 1;
		int nodeLevel = 0;
		while (root.left != null || root.right != null) {
			int leftLevel = nodeLevel;
			int rightLevel = nodeLevel;
			if (root.left != null) {
				TreeNode leftNode = root.left;
				while (leftNode != null) {
					leftLevel++;
					leftNode = leftNode.right;
				}
			}

			if (root.right != null) {
				TreeNode rightNode = root.right;
				while (rightNode != null) {
					rightLevel++;
					rightNode = rightNode.left;
				}
			}

			if (leftLevel == rightLevel && leftLevel == actualLevel) {
				root = root.right;
				nodeIndex = (2 * nodeIndex) + 1;
			} else {
				root = root.left;
				nodeIndex = 2 * nodeIndex;
			}

			nodeLevel++;
		}
		return nodeIndex;
	}

	// helper method to compute the height of binary tree.
	public int computeDepth(TreeNode root) {
		int level = -1;
		for (TreeNode temp = root; temp != null; temp = temp.left) {
			level++;
		}
		return level;
	}

}
