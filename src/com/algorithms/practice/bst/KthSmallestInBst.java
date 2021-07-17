package com.algorithms.practice.bst;

import java.util.ArrayDeque;

import com.algorithms.practice.tree.TreeNode;

public class KthSmallestInBst {

	// Given the root of a binary search tree, and an integer k, return the kth
	// (1-indexed) smallest element in the tree.

	// Follow up: If the BST is modified often (i.e., we can do insert and delete
	// operations) and you need to find the kth smallest frequently, how would you
	// optimize?

	public int count = 0;
	public int kthSmall = -1;

	// naive solution.
	public int kthSmallest(TreeNode root, int k) {
		kthSmallestRec(root, k);
		return kthSmall;
	}

	// helper method for doing recursion.
	public void kthSmallestRec(TreeNode root, int k) {
		if (root == null) {
			return;
		}
		kthSmallestRec(root.left, k);
		count++;
		if (count == k) {
			kthSmall = root.data;
			return;
		}
		kthSmallestRec(root.right, k);
	}

	// iterative naive solution
	public int kthSmallIterative(TreeNode root, int k) {
		ArrayDeque<TreeNode> st = new ArrayDeque<>();
		int count = 0;
		int res = -1;
		TreeNode curr = root;
		while (!st.isEmpty() || curr != null) {
			while (curr != null) {
				st.push(curr);
				curr = curr.left;
			}
			count++;
			TreeNode poppedNode = st.pop();
			if (count == k) {
				res = poppedNode.data;
				break;
			}
			curr = poppedNode.right;
		}
		return res;
	}

	// optimized tree node for bst.
	class OptimizedTreeNode {
		OptimizedTreeNode left;
		OptimizedTreeNode right;
		int leftCount;
		int data;

		OptimizedTreeNode(int data) {
			this.left = null;
			this.right = null;
			this.leftCount = 0;
			this.data = data;
		}
	}

	// efficient solution.
	public int kthSmallestEfficient(OptimizedTreeNode root, int k) {
		if (k == root.leftCount + 1) {
			return root.data;
		}
		if (k < root.leftCount + 1) {
			return kthSmallestEfficient(root.left, k);
		}
		return kthSmallestEfficient(root.right, k - (root.leftCount + 1));
	}

	// modified iterative insert operation in bst.
	public OptimizedTreeNode insertIntoBSTIterative(OptimizedTreeNode root, int val) {
		if (root == null) {
			return new OptimizedTreeNode(val);
		}
		OptimizedTreeNode curr = root;
		OptimizedTreeNode prev = root;
		while (curr != null) {
			prev = curr;
			if (val > curr.data) {
				curr = curr.right;
			} else {
				prev.leftCount = prev.leftCount + 1;
				curr = curr.left;
			}
		}
		if (val > prev.data) {
			prev.right = new OptimizedTreeNode(val);
		} else {
			prev.left = new OptimizedTreeNode(val);
		}
		return root;
	}

	// modified delete operation in bst.
	public OptimizedTreeNode deleteNode(OptimizedTreeNode root, int key) {
		if (root == null) {
			return root;
		}
		if (root.data > key) {
			root.leftCount = root.leftCount - 1;
			root.left = deleteNode(root.left, key);
		} else if (root.data < key) {
			root.right = deleteNode(root.right, key);
		} else {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}
			root.data = getMin(root.right);
			root.right = deleteNode(root.right, root.data);
		}
		return root;
	}

	// helper method to find replacement of node.
	public int getMin(OptimizedTreeNode root) {
		while (root.left != null) {
			root = root.left;
		}
		return root.data;
	}

}
