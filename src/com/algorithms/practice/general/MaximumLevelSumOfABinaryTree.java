package com.algorithms.practice.general;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import com.algorithms.practice.tree.TreeNode;

public class MaximumLevelSumOfABinaryTree {

	// Given the root of a binary tree, the level of its root is 1, the level of its
	// children is 2, and so on.

	// Return the smallest level x such that the sum of all the values of nodes at
	// level x is maximal.

	// The number of nodes in the tree is in the range [1, 10^4].

	// bfs solution.
	public int maxLevelSumBfs(TreeNode root) {
		int level = 0;
		int maxSum = Integer.MIN_VALUE;
		ArrayDeque<TreeNode> q = new ArrayDeque<>();
		q.offer(root);
		int count = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			int sum = 0;
			for (int i = 0; i < size; i++) {
				TreeNode poppedNode = q.poll();
				sum += poppedNode.data;
				if (poppedNode.left != null) {
					q.offer(poppedNode.left);
				}
				if (poppedNode.right != null) {
					q.offer(poppedNode.right);
				}
			}
			if (sum > maxSum) {
				maxSum = sum;
				level = count;
			}
			count++;
		}
		return level;
	}

	// dfs solution.
	public int maxLevelSumDfs(TreeNode root) {
		int level = 0;
		int maxSum = Integer.MIN_VALUE;
		List<Integer> result = new ArrayList<>();
		dfs(root, result, 0);
		for (int i = 0; i < result.size(); i++) {
			int sum = result.get(i);
			if (sum > maxSum) {
				maxSum = sum;
				level = i + 1;
			}
		}
		return level;
	}

	private void dfs(TreeNode root, List<Integer> result, int level) {
		if (level == result.size()) {
			result.add(0);
		}
		result.set(level, result.get(level) + root.data);
		if (root.left != null) {
			dfs(root.left, result, level + 1);
		}
		if (root.right != null) {
			dfs(root.right, result, level + 1);
		}
	}

}
