package com.algorithms.practice.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

	// iterative solution.
	public static List<Integer> postorderTraversalIter(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		ArrayDeque<TreeNode> st = new ArrayDeque<>();
		st.push(root);
		TreeNode curr = root;
		while (!st.isEmpty()) {
			TreeNode poppedNode = st.pop();
			result.add(poppedNode.val);
			if (poppedNode.left != null) {
				st.push(poppedNode.left);
			}
			if (poppedNode.right != null) {
				st.push(poppedNode.right);
			}
		}
		Collections.reverse(result);
		return result;
	}
}
