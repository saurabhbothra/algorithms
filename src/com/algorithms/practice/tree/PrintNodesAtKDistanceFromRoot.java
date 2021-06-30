package com.algorithms.practice.tree;

public class PrintNodesAtKDistanceFromRoot {

	// Write a function that takes root and k as a parameter, whose return type is
	// void and is supposed to print the nodes at distance k from the root.

	// Nodes at distance k from the root are basically the nodes at (k+1)th level of
	// the Binary Tree.

	// efficient solution.
	public static void printNodesAtKDistance(TreeNode root, int k) {
		if (root == null) {
			return;
		}
		if (k == 0) {
			System.out.print(root.data);
			return;
		}
		printNodesAtKDistance(root.left, k - 1);
		printNodesAtKDistance(root.right, k - 1);
	}
}
