package com.algorithms.practice.general;

import java.util.ArrayList;
import java.util.List;

import com.algorithms.practice.tree.TreeNode;

public class PathSum2 {

	// Given the root of a binary tree and an integer targetSum, return all
	// root-to-leaf paths where the sum of the node values in the path equals
	// targetSum. Each path should be returned as a list of the node values, not
	// node references.

	// A root-to-leaf path is a path starting from the root and ending at any leaf
	// node. A leaf is a node with no children.

	// dfs plus backtracking.
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		pathRec(root, targetSum, new ArrayList<>(), result);
		return result;
	}

	private void pathRec(TreeNode root, int targetSum, List<Integer> temp, List<List<Integer>> result) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null && targetSum - root.data == 0) {
			List<Integer> res = new ArrayList<>(temp);
			res.add(root.data);
			result.add(res);
			return;
		}
		temp.add(root.data);
		pathRec(root.left, targetSum - root.data, temp, result);
		pathRec(root.right, targetSum - root.data, temp, result);
		temp.remove(temp.size() - 1);
	}

}
