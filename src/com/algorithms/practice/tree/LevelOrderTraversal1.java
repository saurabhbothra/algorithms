package com.algorithms.practice.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal1 {

	// Given the root of a binary tree, return the level order traversal of its
	// nodes' values. (i.e., from left to right, level by level).

	public List<List<Integer>> levels = new ArrayList<>();

	// efficient solution1.
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		TreeNode dummy = new TreeNode(-1);
		Queue<TreeNode> q = new ArrayDeque<>();
		List<Integer> levelList = new ArrayList<>();
		q.offer(root);
		q.offer(dummy);
		while (q.size() > 1) {
			TreeNode poppedNode = q.poll();
			if (poppedNode == dummy) {
				result.add(levelList);
				levelList = new ArrayList<>();
				q.add(dummy);
				continue;
			}
			levelList.add(poppedNode.data);
			if (poppedNode.left != null) {
				q.add(poppedNode.left);
			}
			if (poppedNode.right != null) {
				q.add(poppedNode.right);
			}
		}
		result.add(levelList);
		return result;
	}

	// efficient solution2.
	public static List<List<Integer>> levelOrderEfficient(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> q = new ArrayDeque<>();
		List<Integer> levelList = new ArrayList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			int count = q.size();
			for (int i = 0; i < count; i++) {
				TreeNode poppedNode = q.poll();
				levelList.add(poppedNode.data);
				if (poppedNode.left != null) {
					q.add(poppedNode.left);
				}
				if (poppedNode.right != null) {
					q.add(poppedNode.right);
				}
			}
			result.add(levelList);
			levelList = new ArrayList<>();
		}
		return result;
	}

	// recursive solution.
	public List<List<Integer>> levelOrderRecursive(TreeNode root) {
		if (root == null) {
			return levels;
		}
		this.levelOrderRec(root, 0);
		return levels;
	}

	// helper to method for doing recursion.
	public void levelOrderRec(TreeNode root, int level) {
		if (level == levels.size()) {
			levels.add(new ArrayList<>());
		}
		levels.get(level).add(root.data);
		if (root.left != null) {
			levelOrderRec(root.left, level + 1);
		}
		if (root.right != null) {
			levelOrderRec(root.right, level + 1);
		}
	}
}
