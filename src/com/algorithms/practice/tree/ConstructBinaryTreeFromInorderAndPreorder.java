package com.algorithms.practice.tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPreorder {

	// Given two integer arrays preorder and inorder where preorder is the preorder
	// traversal of a binary tree and inorder is the inorder traversal of the same
	// tree, construct and return the binary tree.

	// preorder and inorder consist of unique values.

	public int preIndex = 0;
	public Map<Integer, Integer> hmap = new HashMap<>();

	// efficient solution.
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		for (int i = 0; i < inorder.length; i++) {
			hmap.put(inorder[i], i);
		}
		TreeNode root = constructRec(preorder, inorder, 0, inorder.length - 1);
		return root;
	}

	// helper method to do recursion.
	public TreeNode constructRec(int[] preorder, int[] inorder, int start, int end) {
		if (start > end) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preIndex]);
		int index = hmap.get(preorder[preIndex]);
		preIndex++;
		root.left = constructRec(preorder, inorder, start, index - 1);
		root.right = constructRec(preorder, inorder, index + 1, end);
		return root;
	}
}
