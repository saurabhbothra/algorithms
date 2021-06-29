package com.algorithms.practice.tree;

public class PostorderTraversal {

	// Implement post order traversal of binary tree. (left subtree -> right subtree
	// -> root)

	// efficient solution.
	public static void postorderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		System.out.print(root.data + " ");
	}
}
