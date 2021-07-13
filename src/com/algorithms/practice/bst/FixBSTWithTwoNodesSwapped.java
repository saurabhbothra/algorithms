package com.algorithms.practice.bst;

import java.util.ArrayList;
import java.util.List;

import com.algorithms.practice.tree.TreeNode;

public class FixBSTWithTwoNodesSwapped {

	// You are given the root of a binary search tree (BST), where exactly two nodes
	// of the tree were swapped by mistake. Recover the tree without changing its
	// structure.

	// Follow up: A solution using O(n) space is pretty straight forward. Could you
	// devise a constant space solution?

	public List<TreeNode> result = new ArrayList<>();
	public TreeNode prev = null;
	public TreeNode first = null;
	public TreeNode second = null;

	// naive solution.
	public void recoverTree(TreeNode root) {
		inorder(root);
		TreeNode first = null;
		TreeNode second = null;
		TreeNode prev = result.get(0);
		int i = 1;
		while (prev.data < result.get(i).data) {
			prev = result.get(i);
			i++;
		}
		first = prev;
		prev = result.get(result.size() - 1);
		i = result.size() - 2;
		while (prev.data > result.get(i).data) {
			prev = result.get(i);
			i--;
		}
		second = prev;
		int temp = first.data;
		first.data = second.data;
		second.data = temp;
	}

	// helper method for inorder traversal.
	public void inorder(TreeNode root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		result.add(root);
		inorder(root.right);
	}

	// efficient solution.
	public void recoverTreeEfficient(TreeNode root) {
		inorderEff(root);
		int temp = first.data;
		first.data = second.data;
		second.data = temp;
	}

	// helper method for inorder traversal.
	public void inorderEff(TreeNode root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		if (prev != null && prev.data > root.data) {
			second = root;
			if (first == null) {
				first = prev;
			} else {
				return;
			}
		}
		prev = root;
		inorder(root.right);
	}

}
