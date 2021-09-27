package com.algorithms.practice.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LevelOrderTraversal2 {

	// Given the root of a binary tree, return the bottom-up level order traversal
	// of its nodes' values. (i.e., from left to right, level by level from leaf to
	// root).

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		ArrayDeque<TreeNode> q = new ArrayDeque<>();
		q.offer(root);
		while (!q.isEmpty()) {
			int count = q.size();
			List<Integer> level = new ArrayList<>();
			for (int i = 0; i < count; i++) {
				TreeNode poppedNode = q.poll();
				level.add(poppedNode.data);
				if (poppedNode.left != null) {
					q.offer(poppedNode.left);
				}
				if (poppedNode.right != null) {
					q.offer(poppedNode.right);
				}
			}
			result.add(level);
		}
		Collections.reverse(result);
		return result;
	}

}
