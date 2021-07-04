package com.algorithms.practice.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//this class represents a tree node and its index in the binary tree.
class NodeDetails {
	TreeNode node;
	int index;

	NodeDetails(TreeNode node, int index) {
		this.node = node;
		this.index = index;
	}
}

public class MaximumWidthOfBinaryTree2 {

	// Given the root of a binary tree, return the maximum width of the given tree.

	// The maximum width of a tree is the maximum width among all levels.

	// The width of one level is defined as the length between the end-nodes (the
	// leftmost and rightmost non-null nodes), where the null nodes between the
	// end-nodes are also counted into the length calculation.

	// It is guaranteed that the answer will in the range of 32-bit signed integer.

	public List<List<Integer>> levelList = new ArrayList<>();
	public int maxWidth = 0;

	// recursive solution.
	public int widthOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		maxWidthRec(root, 0, 1);
		return maxWidth;
	}

	// helper method for doing recursion.
	public void maxWidthRec(TreeNode node, int level, int index) {
		if (level == levelList.size()) {
			levelList.add(new ArrayList<>());
		}
		List<Integer> currList = levelList.get(level);
		currList.add(index);
		maxWidth = Math.max(maxWidth, (index - currList.get(0) + 1));
		if (node.left != null) {
			maxWidthRec(node.left, level + 1, (2 * index));
		}
		if (node.right != null) {
			maxWidthRec(node.right, level + 1, (2 * index) + 1);
		}
	}

	// iterative solution.
	public int widthOfBinaryTreeIterative(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<NodeDetails> q = new ArrayDeque<>();
		q.offer(new NodeDetails(root, 1));
		int maxWidth = 1;
		while (!q.isEmpty()) {
			int count = q.size();
			int leftIndex = 0;
			int rightIndex = 0;
			for (int i = 0; i < count; i++) {
				NodeDetails poppedNode = q.poll();
				if (i == 0) {
					leftIndex = poppedNode.index;
				}
				if (i == count - 1) {
					rightIndex = poppedNode.index;
				}
				if (poppedNode.node.left != null) {
					q.offer(new NodeDetails(poppedNode.node.left, (2 * poppedNode.index)));
				}
				if (poppedNode.node.right != null) {
					q.offer(new NodeDetails(poppedNode.node.right, (2 * poppedNode.index) + 1));
				}
			}
			maxWidth = Math.max(maxWidth, rightIndex - leftIndex + 1);
		}
		return maxWidth;
	}
}
