package com.algorithms.practice.tree;

import java.util.ArrayList;
import java.util.List;

public class LCAOfBinaryTree {

	// Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
	// in the tree.

	// The lowest common ancestor is defined between two nodes p and q as the lowest
	// node in T that has both p and q as descendants (where we allow a node to be a
	// descendant of itself).

	// The number of nodes in the tree is in the range [2, 10^5].
	// All Node.val are unique.
	// p != q
	// p and q will exist in the tree.

	// recursive solution.
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (root == p || root == q) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null) {
			return root;
		}
		if (left != null) {
			return left;
		}
		return right;
	}

	// iterative solution.
	public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
		List<TreeNode> path1 = new ArrayList<>();
		List<TreeNode> path2 = new ArrayList<>();
		findPath(root, p, path1);
		findPath(root, q, path2);
		TreeNode lcaNode = null;
		for (int i = 0; i < path1.size() && i < path2.size(); i++) {
			if (path1.get(i) == path2.get(i)) {
				lcaNode = path1.get(i);
			} else {
				break;
			}
		}
		return lcaNode;
	}

	// helper method to find path of target node.
	public boolean findPath(TreeNode root, TreeNode target, List<TreeNode> path) {
		if (root == null) {
			return false;
		}
		path.add(root);
		if (root == target) {
			return true;
		}
		boolean lflag = findPath(root.left, target, path);
		boolean rflag = findPath(root.right, target, path);
		if (lflag || rflag) {
			return true;
		}
		path.remove(path.size() - 1);
		return false;
	}

}
