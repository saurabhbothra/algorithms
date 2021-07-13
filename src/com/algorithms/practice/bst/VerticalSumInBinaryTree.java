package com.algorithms.practice.bst;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import com.algorithms.practice.tree.TreeNode;

public class VerticalSumInBinaryTree {

	// Given a binary tree, we need to find sum of nodes in all vertical lines
	// starting from leftmost line to rightmost.

	// Nodes in same vertical line have same horizontal distance from root.

	public List<Integer> result = new ArrayList<>();
	public Map<Integer, Integer> hmap = new HashMap<>();
	public Integer maxIndex = Integer.MIN_VALUE;
	public Integer minIndex = Integer.MAX_VALUE;

	// efficient solution.
	public List<Integer> verticalSum(TreeNode root) {
		vSumRec(root, 0);
		for (int i = minIndex; i <= maxIndex; i++) {
			result.add(hmap.get(i));
		}
		return result;
	}

	// helper method for doing recursion.
	public void vSumRec(TreeNode root, int hdist) {
		if (root == null) {
			return;
		}
		minIndex = Math.min(minIndex, hdist);
		maxIndex = Math.max(maxIndex, hdist);
		if (hmap.containsKey(hdist)) {
			hmap.put(hdist, hmap.get(hdist) + root.data);
		} else {
			hmap.put(hdist, root.data);
		}
		vSumRec(root.left, hdist - 1);
		vSumRec(root.right, hdist + 1);
	}

}
