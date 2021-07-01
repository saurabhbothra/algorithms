package com.algorithms.practice.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class RightViewOfBinaryTree {

	// Given the root of the binary tree, imagine yourself standing on the right
	// side
	// of it, return the values of the nodes you can see ordered from top to bottom.

	public List<Integer> result = new ArrayList<>();

	// recursive solution.
	public List<Integer> rightViewRecursive(TreeNode root) {
		if (root == null) {
			return result;
		}
		rightViewRec(root, 0);
		return result;
	}

	// helper method for doing recursion.
	public void rightViewRec(TreeNode root, int level) {
		if (level == result.size()) {
			result.add(root.data);
		}
		if (root.right != null) {
			rightViewRec(root.right, level + 1);
		}
		if (root.left != null) {
			rightViewRec(root.left, level + 1);
		}
	}

	// iterative solution.
	public List<Integer> rightView(TreeNode root) {
		List<Integer> rightViewList = new ArrayList<>();
		if (root == null) {
			return rightViewList;
		}
		Queue<TreeNode> q = new ArrayDeque<>();
		q.add(root);
		while (!q.isEmpty()) {
			int count = q.size();
			for (int i = 0; i < count; i++) {
				TreeNode poppedNode = q.poll();
				if (i == count - 1) {
					rightViewList.add(poppedNode.data);
				}
				if (poppedNode.left != null) {
					q.offer(poppedNode.left);
				}
				if (poppedNode.right != null) {
					q.offer(poppedNode.right);
				}
			}
		}
		return rightViewList;
	}
}
