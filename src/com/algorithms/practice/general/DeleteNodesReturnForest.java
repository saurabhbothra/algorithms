package com.algorithms.practice.general;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.algorithms.practice.tree.TreeNode;

public class DeleteNodesReturnForest {

	// Given the root of a binary tree, each node in the tree has a distinct value.

	// After deleting all nodes with a value in to_delete, we are left with a forest
	// (a disjoint union of trees).

	// Return the roots of the trees in the remaining forest. You may return the
	// result in any order.

	// dfs solution.
	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		Set<Integer> hset = new HashSet<>();
		for (int i : to_delete) {
			hset.add(i);
		}
		List<TreeNode> result = new ArrayList<>();
		root = validate(root, hset, result);
		if (root != null) {
			result.add(root);
		}
		return result;
	}

	private TreeNode validate(TreeNode root, Set<Integer> hset, List<TreeNode> result) {
		if (root == null) {
			return null;
		}

		TreeNode left = validate(root.left, hset, result);
		TreeNode right = validate(root.right, hset, result);
		if (hset.contains(root.data)) {
			if (left != null) {
				result.add(left);
			}
			if (right != null) {
				result.add(right);
			}
			return null;
		}
		root.left = left;
		root.right = right;
		return root;
	}

}
