package com.algorithms.practice.tree;

public class ConvertBinaryTreeToDoublyLinkedList {

	// Given a binary tree, convert it to doubly linked list in place.
	// Inorder traversal.
	// Use left of TreeNode as prev of doubly linked list.
	// Use right of TreeNode as next of doubly linked list.

	public TreeNode head = null;
	public TreeNode prev = null;

	// recursive solution.
	public TreeNode convertToDoublyLinkedList(TreeNode root) {
		convert(root);
		return head;
	}

	// helper method to do recursion.
	public void convert(TreeNode root) {
		if (root == null) {
			return;
		}
		convert(root.left);
		if (head == null) {
			head = root;
			prev = root;
		} else {
			prev.right = root;
			root.left = prev;
			prev = root;
		}
		convert(root.right);
	}
}
