package com.algorithms.practice.bst;

import com.algorithms.practice.tree.TreeNode;

public class FloorInBst {

	// Given a Binary search tree and a value X, the task is to complete the
	// function which will return the floor of x.

	// Note: Floor(X) is an element that is either equal to X or immediately smaller
	// to X. If no such element exits return -1.

	public int floorValue = -1;

	// efficient recursive solution.
	public int floor(TreeNode root, int key) {
		floorRec(root, key);
		return floorValue;
	}

	// helper method for doing recursion.
	public void floorRec(TreeNode root, int key) {
		if (root == null) {
			return;
		}
		if (root.data == key) {
			floorValue = key;
		} else if (key > root.data) {
			floorValue = Math.max(floorValue, root.data);
			floorRec(root.right, key);
		} else {
			floorRec(root.left, key);
		}
	}

	// efficient iterative solution.
	public int floorIterative(TreeNode root, int key) {
		int floorValue = -1;
		while (root != null) {
			if (root.data == key) {
				floorValue = key;
				break;
			} else if (key > root.data) {
				floorValue = Math.max(floorValue, root.data);
				root = root.right;
			} else {
				root = root.left;
			}
		}
		return floorValue;
	}

}
