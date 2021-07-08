package com.algorithms.practice.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

	// Implement inorder traversal of binary tree. (left subtree -> root -> right
	// subtree)

	// efficient recursive solution.
	public static void inorderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		inorderTraversal(root.left);
		System.out.print(root.data + " ");
		inorderTraversal(root.right);
	}

	// efficient iterative solution.
	public List<Integer> inorderTraversalIterative(TreeNode root) {
		List<Integer> inorderList = new ArrayList<>();
		if (root == null) {
			return inorderList;
		}
		ArrayDeque<TreeNode> st = new ArrayDeque<>();
		st.push(root);
		TreeNode curr = root;
		while (!st.isEmpty()) {
			while (curr != null && curr.left != null) {
				st.push(curr.left);
				curr = curr.left;
			}
			TreeNode poppedNode = st.pop();
			inorderList.add(poppedNode.data);
			curr = poppedNode.right;
			if (curr != null) {
				st.push(curr);
			}
		}
		return inorderList;
	}

}
