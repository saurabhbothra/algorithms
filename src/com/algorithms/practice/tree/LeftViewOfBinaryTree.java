package com.algorithms.practice.tree;

import java.util.List;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class LeftViewOfBinaryTree {

	// Given the root of the binary tree, imagine yourself standing on the left side
	// of it, return the values of the nodes you can see ordered from top to bottom.

	public List<Integer> result = new ArrayList<>();

	// recursive solution.
	public List<Integer> leftViewRec(TreeNode root) {
		if (root == null) {
			return result;
		}
		leftViewRec(root, 0);
		return result;
	}

	// helper method for doing recursion.
	public void leftViewRec(TreeNode root, int level) {
		if (level == result.size()) {
			result.add(root.data);
		}
		if (root.left != null) {
			leftViewRec(root.left, level + 1);
		}
		if (root.right != null) {
			leftViewRec(root.right, level + 1);
		}
	}

	// iterative solution.
	public List<Integer> leftView(TreeNode root) {
		List<Integer> leftViewList = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> q = new ArrayDeque<>();
		q.add(root);
		while (!q.isEmpty()) {
			int count = q.size();
			leftViewList.add(q.peek().data);
			for (int i = 0; i < count; i++) {
				TreeNode poppedNode = q.poll();
				if (poppedNode.left != null) {
					q.offer(poppedNode.left);
				}
				if (poppedNode.right != null) {
					q.offer(poppedNode.right);
				}
			}
		}
		return leftViewList;
	}
}
