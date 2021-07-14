package com.algorithms.practice.bst;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.algorithms.practice.tree.TreeNode;

public class VerticalTraversalOfBinaryTree {

	// Given the root of a binary tree, return the vertical order traversal of its
	// nodes' values. (i.e., from top to bottom, column by column).

	// If two nodes are in the same row and column, the order should be from left to
	// right.

	class NodeDetails {
		TreeNode node;
		int horizontalDistance;

		NodeDetails(TreeNode node, int horizontalDistance) {
			this.node = node;
			this.horizontalDistance = horizontalDistance;
		}
	}

	// efficient solution.
	public List<List<Integer>> verticalOrder(TreeNode root) {
		Map<Integer, List<Integer>> hmap = new HashMap<>();
		List<List<Integer>> result = new ArrayList<>();
		ArrayDeque<NodeDetails> q = new ArrayDeque<>();
		Integer minIndex = Integer.MAX_VALUE;
		Integer maxIndex = Integer.MIN_VALUE;
		if (root == null) {
			return result;
		}
		q.add(new NodeDetails(root, 0));
		while (!q.isEmpty()) {
			int count = q.size();
			for (int i = 0; i < count; i++) {
				NodeDetails popped = q.poll();
				TreeNode poppedNode = popped.node;
				int hdist = popped.horizontalDistance;
				minIndex = Math.min(minIndex, hdist);
				maxIndex = Math.max(maxIndex, hdist);
				if (!hmap.containsKey(hdist)) {
					hmap.put(hdist, new ArrayList<>());
				}
				hmap.get(hdist).add(poppedNode.data);
				if (poppedNode.left != null) {
					q.offer(new NodeDetails(poppedNode.left, hdist - 1));
				}
				if (poppedNode.right != null) {
					q.offer(new NodeDetails(poppedNode.right, hdist + 1));
				}
			}
		}
		for (int i = minIndex; i <= maxIndex; i++) {
			result.add(hmap.get(i));
		}
		return result;
	}

}
