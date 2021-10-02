package com.algorithms.practice.general;

import java.util.ArrayDeque;

// You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. 
// The binary tree has the following definition:

/*

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

*/

// You may only use constant extra space.
// The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.

class INode {

	public int val;
	public INode left;
	public INode right;
	public INode next;

	public INode() {
	}

	public INode(int _val) {
		val = _val;
	}

	public INode(int _val, INode _left, INode _right, INode _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
}

public class PopulatingNextRightPointersInEachNode {

	// dfs solution.
	public INode connect(INode root) {
		return connectRec(root, null);
	}

	private INode connectRec(INode root, INode right) {
		if (root == null) {
			return null;
		}
		root.next = right;
		root.left = connectRec(root.left, root.right);
		INode temp = (right == null) ? null : right.left;
		root.right = connectRec(root.right, temp);
		return root;
	}

	// bfs solution.
	public INode connectBfs(INode root) {
		if (root == null) {
			return null;
		}
		ArrayDeque<INode> q = new ArrayDeque<>();
		q.offer(root);
		while (!q.isEmpty()) {
			int count = q.size();
			for (int i = 0; i < count; i++) {
				INode poppedNode = q.poll();
				if (i < count - 1) {
					poppedNode.next = q.peek();
				}
				if (poppedNode.left != null) {
					q.offer(poppedNode.left);
				}

				if (poppedNode.right != null) {
					q.offer(poppedNode.right);
				}
			}
		}
		return root;
	}

}
