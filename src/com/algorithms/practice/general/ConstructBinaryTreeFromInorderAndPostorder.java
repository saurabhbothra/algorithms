package com.algorithms.practice.general;

import java.util.Map;
import java.util.HashMap;

import com.algorithms.practice.tree.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorder {

	// Given two integer arrays inorder and postorder where inorder is the inorder
	// traversal of a binary tree and postorder is the postorder traversal of the
	// same tree, construct and return the binary tree.

	// inorder and postorder consist of unique values.
	// Each value of postorder also appears in inorder.
	// inorder is guaranteed to be the inorder traversal of the tree.
	// postorder is guaranteed to be the postorder traversal of the tree.

	public int index = 0;

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		Map<Integer, Integer> hmap = new HashMap<>();
		index = inorder.length - 1;
		for (int i = 0; i < inorder.length; i++) {
			hmap.put(inorder[i], i);
		}
		return build(inorder, hmap, postorder, 0, index);
	}

	private TreeNode build(int[] inorder, Map<Integer, Integer> hmap, int[] postorder, int start, int end) {
		if (start > end) {
			return null;
		}
		TreeNode node = new TreeNode(postorder[index]);
		index--;
		node.right = build(inorder, hmap, postorder, hmap.get(node.data) + 1, end);
		node.left = build(inorder, hmap, postorder, start, hmap.get(node.data) - 1);
		return node;
	}

}
