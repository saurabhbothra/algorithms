package com.algorithms.practice.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {

	// Given a binary tree, find the maximum width of the binary tree.
	// Maximum Width of Binary tree is the maximum number of nodes present in a
	// level of the Tree.

	// iterative solution.
	public static int maximumWidthIterative(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int maxWidth = 1;
		Queue<TreeNode> q = new ArrayDeque<>();
		q.offer(root);
		while (!q.isEmpty()) {
			int count = q.size();
			if (count > maxWidth) {
				maxWidth = count;
			}
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
		return maxWidth;
	}
}
