package com.algorithms.practice.general;

import java.util.ArrayDeque;

import com.algorithms.practice.tree.TreeNode;

// Given the root of a binary tree, invert the tree, and return its root.

public class InvertABinaryTree {

	// dfs solution.
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode temp = root.right;
		root.right = invertTree(root.left);
		root.left = invertTree(temp);
		return root;
	}

	// bfs solution.
	public TreeNode invertTreeBfs(TreeNode root) {
		if (root == null) {
			return null;
		}
		ArrayDeque<TreeNode> q = new ArrayDeque<>();
		q.offer(root);
		while (!q.isEmpty()) {
			TreeNode poppedNode = q.poll();
			TreeNode temp = poppedNode.right;
			poppedNode.right = poppedNode.left;
			poppedNode.left = temp;
			if (poppedNode.left != null) {
				q.offer(poppedNode.left);
			}

			if (poppedNode.right != null) {
				q.offer(poppedNode.right);
			}
		}
		return root;
	}

}
