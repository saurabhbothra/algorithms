package com.algorithms.practice.tree;

import java.util.ArrayList;
import java.util.List;

public class LCA2 {

	// Given the root of a binary tree, return the lowest common ancestor (LCA) of
	// two given nodes, p and q. If either node p or q does not exist in the tree,
	// return null. All values of the nodes in the tree are unique.

	// According to the definition of LCA on Wikipedia: "The lowest common ancestor
	// of two nodes p and q in a binary tree T is the lowest node that has both p
	// and q as descendants (where we allow a node to be a descendant of itself)". A
	// descendant of a node x is a node y that is on the path from node x to some
	// leaf node.

	// Follow up: Can you find the LCA traversing the tree, without checking nodes
	// existence?

	// solution by finding paths.
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}

		List<TreeNode> path1 = new ArrayList<>();
		List<TreeNode> path2 = new ArrayList<>();

		if (!lcaPath(root, p, path1)) {
			return null;
		}
		if (!lcaPath(root, q, path2)) {
			return null;
		}

		TreeNode lca = null;
		for (int i = 0; i < path1.size() && i < path2.size(); i++) {
			if (path1.get(i) == path2.get(i)) {
				lca = path1.get(i);
			} else {
				break;
			}
		}
		return lca;

	}

	private boolean lcaPath(TreeNode root, TreeNode target, List<TreeNode> path) {
		if (root == null) {
			return false;
		}
		path.add(root);
		if (root == target) {
			return true;
		}

		boolean flag1 = lcaPath(root.left, target, path);
		boolean flag2 = lcaPath(root.right, target, path);
		if (flag1 || flag2) {
			return true;
		}
		path.remove(path.size() - 1);
		return false;
	}

}
