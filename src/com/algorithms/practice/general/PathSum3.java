package com.algorithms.practice.general;

import java.util.Map;
import java.util.HashMap;

import com.algorithms.practice.tree.TreeNode;

public class PathSum3 {

	// Given the root of a binary tree and an integer targetSum, return the number
	// of paths where the sum of the values along the path equals targetSum.

	// The path does not need to start or end at the root or a leaf, but it must go
	// downwards (i.e., traveling only from parent nodes to child nodes).

	public int count = 0;

	public int pathSum(TreeNode root, int targetSum) {
		Map<Integer, Integer> hmap = new HashMap<>();
		hmap.put(0, 1);
		pathRec(root, targetSum, hmap, 0);
		return count;
	}

	private void pathRec(TreeNode root, int targetSum, Map<Integer, Integer> hmap, int currSum) {
		if (root == null) {
			return;
		}
		currSum = currSum + root.data;
		int complement = currSum - targetSum;
		if (hmap.containsKey(complement)) {
			count = count + hmap.get(complement);
		}
		hmap.put(currSum, hmap.getOrDefault(currSum, 0) + 1);
		pathRec(root.left, targetSum, hmap, currSum);
		pathRec(root.right, targetSum, hmap, currSum);
		if (hmap.get(currSum) == 1) {
			hmap.remove(currSum);
		} else {
			hmap.put(currSum, hmap.get(currSum) - 1);
		}
	}

}
