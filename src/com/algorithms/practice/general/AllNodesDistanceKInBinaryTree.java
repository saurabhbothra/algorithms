package com.algorithms.practice.general;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.algorithms.practice.tree.TreeNode;

// Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

// You can return the answer in any order.

// The number of nodes in the tree is in the range [1, 500].
// 0 <= Node.val <= 500
// All the values Node.val are unique.
// target is the value of one of the nodes in the tree.
// 0 <= k <= 1000

class NodeDetails {
	TreeNode node;
	int dist;

	NodeDetails(TreeNode node, int dist) {
		this.node = node;
		this.dist = dist;
	}
}

public class AllNodesDistanceKInBinaryTree {

	// dfs to find parent and bfs to find nodes at distance k.
	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		List<Integer> result = new ArrayList<>();
		Map<TreeNode, TreeNode> hmap = new HashMap<>();
		Map<TreeNode, Boolean> visited = new HashMap<>();
		dfs(root, null, visited, hmap);
		ArrayDeque<NodeDetails> q = new ArrayDeque<>();
		q.offer(new NodeDetails(target, 0));
		visited.put(target, true);
		while (!q.isEmpty()) {
			NodeDetails stats = q.poll();
			TreeNode poppedNode = stats.node;
			int dist = stats.dist;
			if (dist == k) {
				result.add(poppedNode.data);
			}
			if (poppedNode.left != null && !visited.get(poppedNode.left)) {
				q.offer(new NodeDetails(poppedNode.left, dist + 1));
				visited.put(poppedNode.left, true);
			}
			if (poppedNode.right != null && !visited.get(poppedNode.right)) {
				q.offer(new NodeDetails(poppedNode.right, dist + 1));
				visited.put(poppedNode.right, true);
			}
			if (hmap.get(poppedNode) != null && !visited.get(hmap.get(poppedNode))) {
				q.offer(new NodeDetails(hmap.get(poppedNode), dist + 1));
				visited.put(hmap.get(poppedNode), true);
			}
		}
		return result;
	}

	private void dfs(TreeNode root, TreeNode parent, Map<TreeNode, Boolean> visited, Map<TreeNode, TreeNode> hmap) {
		if (root == null) {
			return;
		}
		hmap.put(root, parent);
		visited.put(root, false);
		dfs(root.left, root, visited, hmap);
		dfs(root.right, root, visited, hmap);
	}
}
