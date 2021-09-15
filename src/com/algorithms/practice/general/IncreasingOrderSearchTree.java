package com.algorithms.practice.general;

import java.util.ArrayList;
import java.util.List;

import com.algorithms.practice.tree.TreeNode;

public class IncreasingOrderSearchTree {

	// Given the root of a binary search tree, rearrange the tree in in-order so
	// that the leftmost node in the tree is now the root of the tree, and every
	// node has no left child and only one right child.

	// naive solution, using two traversals of tree.
	public TreeNode increasingBSTNaive(TreeNode root) {
		List<TreeNode> result = new ArrayList<>();
		increaseRec(root, result);
		root = result.get(0);
		TreeNode curr = root;
		for (int i = 1; i < result.size(); i++) {
			curr.left = null;
			curr.right = result.get(i);
			curr = curr.right;
		}
		curr.left = null;
		curr.right = null;
		return root;
	}

	private void increaseRec(TreeNode root, List<TreeNode> result) {
		if (root == null) {
			return;
		}
		increaseRec(root.left, result);
		result.add(root);
		increaseRec(root.right, result);
	}

	// efficient solution, using relinking of nodes and only one traversal of tree.
	public TreeNode curr = null;

	public TreeNode increasingBSTEff(TreeNode root) {
		TreeNode ans = new TreeNode(0);
		curr = ans;
		inorder(root);
		curr.left = null;
		curr.right = null;
		return ans.right;
	}

	private void inorder(TreeNode root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		curr.left = null;
		curr.right = root;
		curr = curr.right;
		inorder(root.right);
	}

	// efficient solution, using one traversal of tree.
	public TreeNode increasingBST(TreeNode root) {
		return null;
	}

}
