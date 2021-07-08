package com.algorithms.practice.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {

	// Implement pre order traversal of binary tree. (root -> left subtree -> right
	// subtree)

	// efficient recursive solution.
	public static void preorderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preorderTraversal(root.left);
		preorderTraversal(root.right);
	}

	// simple iterative solution.
	public List<Integer> preorderTraversalIterativeSimple(TreeNode root) {
		List<Integer> preorderList = new ArrayList<>();
		if (root == null) {
			return preorderList;
		}
		ArrayDeque<TreeNode> st = new ArrayDeque<>();
		st.push(root);
		while (!st.isEmpty()) {
			TreeNode poppedNode = st.pop();
			preorderList.add(poppedNode.data);
			if (poppedNode.right != null) {
				st.push(poppedNode.right);
			}
			if (poppedNode.left != null) {
				st.push(poppedNode.left);
			}
		}
		return preorderList;
	}

	// space optimized iterative solution.
	public List<Integer> preorderTraversalIterativeEfficient(TreeNode root) {
		List<Integer> preorderList = new ArrayList<>();
		if (root == null) {
			return preorderList;
		}
		ArrayDeque<TreeNode> st = new ArrayDeque<>();
		st.push(root);
		TreeNode curr = root;
		while (!st.isEmpty()) {
			while (curr != null) {
				preorderList.add(curr.data);
				if (curr.right != null) {
					st.push(curr.right);
				}
				curr = curr.left;
			}
			curr = st.pop();
		}
		return preorderList;
	}
}
