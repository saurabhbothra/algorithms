package com.algorithms.practice.tree;

public class PreorderTraversal {

	// Implement pre order traversal of binary tree. (root -> left subtree -> right
	// subtree)

	// efficient solution.
	public static void preorderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preorderTraversal(root.left);
		preorderTraversal(root.right);
	}
}
