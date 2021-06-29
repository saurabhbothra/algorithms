package com.algorithms.practice.tree;

public class InorderTraversal {

	// Implement inorder traversal of binary tree. (left subtree -> root -> right
	// subtree)

	// efficient solution.
	public static void inorderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		inorderTraversal(root.left);
		System.out.print(root.data + " ");
		inorderTraversal(root.right);
	}

}
