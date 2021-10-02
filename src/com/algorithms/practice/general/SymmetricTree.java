package com.algorithms.practice.general;

import java.util.ArrayDeque;

import com.algorithms.practice.tree.TreeNode;

// Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

public class SymmetricTree {

	// dfs solution.
	public boolean isSymmetric(TreeNode root) {
		return isSymmetricRec(root, root);
	}

	private boolean isSymmetricRec(TreeNode curr1, TreeNode curr2) {
		if (curr1 == null && curr2 == null) {
			return true;
		}

		if (curr1 == null || curr2 == null) {
			return false;
		}

		if (curr1.data != curr2.data) {
			return false;
		}

		return isSymmetricRec(curr1.left, curr2.right) && isSymmetricRec(curr1.right, curr2.left);
	}

	// bfs solution.
	public boolean isSymmetricBfs(TreeNode root) {
		if (root == null) {
			return true;
		}
		return bfs(root, root);
	}

	private boolean bfs(TreeNode curr1, TreeNode curr2) {
		ArrayDeque<TreeNode> q = new ArrayDeque<>();
		TreeNode dummy = new TreeNode(-1);
		q.offer(curr1);
		q.offer(curr2);
		while (!q.isEmpty()) {
			TreeNode p1 = q.poll();
			TreeNode p2 = q.poll();
			if (p1 == dummy && p2 == dummy) {
				continue;
			}
			if (p1 == dummy || p2 == dummy) {
				return false;
			}
			if (p1.data != p2.data) {
				return false;
			}
			q.offer((p1.left == null) ? dummy : p1.left);
			q.offer((p2.right == null) ? dummy : p2.right);
			q.offer((p1.right == null) ? dummy : p1.right);
			q.offer((p2.left == null) ? dummy : p2.left);
		}
		return true;
	}
}
