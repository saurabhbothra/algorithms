package com.algorithms.practice.tree;

public class BurnABinaryTreeFromLeaf {

	// Given a binary tree and a leaf node, we need to find time to burn the full
	// binary tree if we burn the given leaf at 0-th second.

	// If leaf is not found, return -1.

	class Distance {
		public int val;

		Distance(int val) {
			this.val = val;
		}
	}

	public int maxDistance = 0;
	public boolean isLeafFound = false;

	// efficient solution,
	public int burn(TreeNode root, int leaf) {
		burnRec(root, leaf, new Distance(-1));
		return isLeafFound ? maxDistance : -1;
	}

	// helper method for doing recursion.
	public int burnRec(TreeNode root, int leaf, Distance dist) {
		if (root == null) {
			return 0;
		}
		if (root.data == leaf) {
			dist.val = 0;
			isLeafFound = true;
			return 1;
		}
		Distance leftChildDistance = new Distance(-1);
		Distance rightChildDistance = new Distance(-1);
		int leftHeight = burnRec(root.left, leaf, leftChildDistance);
		int rightHeight = burnRec(root.right, leaf, rightChildDistance);
		if (leftChildDistance.val != -1) {
			dist.val = leftChildDistance.val + 1;
			maxDistance = Math.max(maxDistance, dist.val + rightHeight);
		} else if (rightChildDistance.val != -1) {
			dist.val = rightChildDistance.val + 1;
			maxDistance = Math.max(maxDistance, dist.val + leftHeight);
		}
		return 1 + Math.max(leftHeight, rightHeight);
	}

}
