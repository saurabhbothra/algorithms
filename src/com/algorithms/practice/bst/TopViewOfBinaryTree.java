package com.algorithms.practice.bst;

import com.algorithms.practice.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopViewOfBinaryTree {

	// Given a binary tree, print top view of binary tree.
	// Top view of binary tree is the set of nodes visible when the tree is viewed
	// from top.
	// Return nodes from left to right.

	class NodeDetails {
		TreeNode node;
		int horizontalDistance;

		NodeDetails(TreeNode node, int horizontalDistance) {
			this.node = node;
			this.horizontalDistance = horizontalDistance;
		}
	}

	// efficient solution.
	public List<Integer> printTopView(TreeNode root) {
		Map<Integer, Integer> hmap = new HashMap<>();
		List<Integer> result = new ArrayList<>();
		ArrayDeque<NodeDetails> q = new ArrayDeque<>();
		Integer minIndex = Integer.MAX_VALUE;
		Integer maxIndex = Integer.MIN_VALUE;
		if (root == null) {
			return result;
		}
		q.offer(new NodeDetails(root, 0));
		while (!q.isEmpty()) {
			int count = q.size();
			for (int i = 0; i < count; i++) {
				NodeDetails popped = q.poll();
				TreeNode poppedNode = popped.node;
				int hdist = popped.horizontalDistance;
				if (!hmap.containsKey(hdist)) {
					hmap.put(hdist, poppedNode.data);
				}
				minIndex = Math.min(minIndex, hdist);
				maxIndex = Math.max(maxIndex, hdist);
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
