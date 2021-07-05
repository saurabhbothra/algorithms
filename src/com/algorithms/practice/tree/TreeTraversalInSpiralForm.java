package com.algorithms.practice.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeTraversalInSpiralForm {

	// Given the root of a binary tree, return the zigzag level order traversal of
	// its nodes' values. (i.e., from left to right, then right to left for the next
	// level and alternate between).

	// recursive solution.
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		zigzagRec(root, 0, true, result);
		return result;
	}

	// helper method for doing recursion.
	public void zigzagRec(TreeNode root, int level, boolean flag, List<List<Integer>> result) {
		if (level == result.size()) {
			LinkedList<Integer> levelList = new LinkedList<>();
			result.add(levelList);
		}
		List<Integer> lList = result.get(level);
		if (flag) {
			lList.add(root.data);
		} else {
			lList.add(0, root.data);
		}

		if (root.left != null) {
			zigzagRec(root.left, level + 1, !flag, result);
		}
		if (root.right != null) {
			zigzagRec(root.right, level + 1, !flag, result);
		}
	}

	// iterative solution.
	public List<List<Integer>> zigzagLevelOrderIterative(TreeNode root) {
		List<List<Integer>> levelOrderList = new ArrayList<>();
		if (root == null) {
			return levelOrderList;
		}
		ArrayDeque<TreeNode> dq = new ArrayDeque<>();
		List<Integer> levelList = new ArrayList<>();
		dq.offerFirst(root);
		boolean level = true;
		while (!dq.isEmpty()) {
			int count = dq.size();
			for (int i = 0; i < count; i++) {
				TreeNode poppedNode = null;
				if (level) {
					poppedNode = dq.pollFirst();
					if (poppedNode.left != null) {
						dq.offerLast(poppedNode.left);
					}
					if (poppedNode.right != null) {
						dq.offerLast(poppedNode.right);
					}
				} else {
					poppedNode = dq.pollLast();
					if (poppedNode.right != null) {
						dq.offerFirst(poppedNode.right);
					}
					if (poppedNode.left != null) {
						dq.offerFirst(poppedNode.left);
					}
				}
				levelList.add(poppedNode.data);
			}
			level = !level;
			levelOrderList.add(levelList);
			levelList = new ArrayList<>();
		}
		return levelOrderList;
	}

}
