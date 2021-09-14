package com.algorithms.practice.general;

import com.algorithms.practice.tree.TreeNode;

public class MergeTwoBinaryTrees {

	// You are given two binary trees root1 and root2.

	// Imagine that when you put one of them to cover the other, some nodes of the
	// two trees are overlapped while the others are not. You need to merge the two
	// trees into a new binary tree. The merge rule is that if two nodes overlap,
	// then sum node values up as the new value of the merged node. Otherwise, the
	// NOT null node will be used as the node of the new tree.

	// Return the merged tree.

	// Note: The merging process must start from the root nodes of both trees.

	// efficient solution.
	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		return mergeRec(root1, root2);
	}

	private TreeNode mergeRec(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return null;
		}
		int sum = 0;
		if (root1 != null) {
			sum += root1.data;
		}
		if (root2 != null) {
			sum += root2.data;
		}
		TreeNode root = new TreeNode(sum);
		root.left = mergeRec((root1 == null) ? null : root1.left, (root2 == null) ? null : root2.left);
		root.right = mergeRec((root1 == null) ? null : root1.right, (root2 == null) ? null : root2.right);
		return root;
	}

}
