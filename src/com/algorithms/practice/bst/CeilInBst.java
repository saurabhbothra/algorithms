package com.algorithms.practice.bst;

import com.algorithms.practice.tree.TreeNode;

public class CeilInBst {

	// Given a Binary search tree and a value X, the task is to complete the
	// function which will return the ceil of x.

	// Note: Ceil(X) is an element that is either equal to X or immediately greater
	// to X. If no such element exits return -1.

	public int ceilValue = -1;

	// efficient recursive solution.
	public int ceil(TreeNode root, int key) {
		ceilRec(root, key);
		return ceilValue;
	}

	// helper method for doing recursion.
	public void ceilRec(TreeNode root, int key) {
		if (root == null) {
			return;
		}
		if (root.data == key) {
			ceilValue = key;
		} else if (key > root.data) {
			ceilRec(root.right, key);
		} else {
			ceilValue = (ceilValue == -1) ? root.data : Math.min(ceilValue, root.data);
			ceilRec(root.left, key);
		}
	}

	// efficient iterative solution.
	public int ceilIterative(TreeNode root, int key) {
		int ceilValue = -1;
		while (root != null) {
			if (root.data == key) {
				ceilValue = key;
				break;
			} else if (key > root.data) {
				root = root.right;
			} else {
				ceilValue = (ceilValue == -1) ? root.data : Math.min(ceilValue, root.data);
				root = root.left;
			}
		}
		return ceilValue;
	}

}
