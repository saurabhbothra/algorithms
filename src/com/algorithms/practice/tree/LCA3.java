package com.algorithms.practice.tree;

class LTNode {
	public int val;
	public LTNode left;
	public LTNode right;
	public LTNode parent;
}

public class LCA3 {

	// dfs solution.
	public LTNode lowestCommonAncestor(LTNode p, LTNode q) {
		if (p.parent == q.parent) {
			return p.parent;
		}
		LTNode curr1 = p;
		while (curr1.parent != null) {
			curr1 = curr1.parent;
		}
		return lca(curr1, p, q);
	}

	private LTNode lca(LTNode root, LTNode p, LTNode q) {
		if (root == null) {
			return null;
		}
		if (root == p || root == q) {
			return root;
		}
		LTNode left = lca(root.left, p, q);
		LTNode right = lca(root.right, p, q);
		if (left != null && right != null) {
			return root;
		}
		if (left == null) {
			return right;
		}
		return left;
	}

}
