package com.algorithms.practice.general;

import java.util.ArrayDeque;

import com.algorithms.practice.tree.TreeNode;

class Pair {
	TreeNode node;
	int currMax;

	Pair(TreeNode node, int currMax) {
		this.node = node;
		this.currMax = currMax;
	}
}

public class CountGoodNodesInABinaryTree {

	// Given a binary tree root, a node X in the tree is named good if in the path
	// from root to X there are no nodes with a value greater than X.

	// Return the number of good nodes in the binary tree.

	// efficient solution, using dfs.
	public int goodNodes(TreeNode root) {
		return goodNodesRec(root, Integer.MIN_VALUE);
	}

	private int goodNodesRec(TreeNode root, int currMax) {
		if (root == null) {
			return 0;
		}
		int count = 0;
		if (currMax <= root.data) {
			count = count + 1;
			currMax = root.data;
		}
		return count + goodNodesRec(root.left, currMax) + goodNodesRec(root.right, currMax);
	}

	// efficient solution using bfs.
	public int goodNodesBfs(TreeNode root) {
		int count = 0;
		ArrayDeque<Pair> q = new ArrayDeque<>();
		q.offer(new Pair(root, root.data));
		while (!q.isEmpty()) {
			Pair poppedPair = q.poll();
			TreeNode poppedNode = poppedPair.node;
			int currMax = poppedPair.currMax;
			if (currMax <= poppedNode.data) {
				count++;
				currMax = poppedNode.data;
			}

			if (poppedNode.left != null) {
				q.offer(new Pair(poppedNode.left, currMax));
			}

			if (poppedNode.right != null) {
				q.offer(new Pair(poppedNode.right, currMax));
			}
		}
		return count;
	}
}
