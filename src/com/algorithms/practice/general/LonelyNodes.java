package com.algorithms.practice.general;

import java.util.ArrayList;
import java.util.List;

import com.algorithms.practice.tree.TreeNode;

public class LonelyNodes {

	// In a binary tree, a lonely node is a node that is the only child of its
	// parent node. The root of the tree is not lonely because it does not have a
	// parent node.

	// Given the root of a binary tree, return an array containing the values of all
	// lonely nodes in the tree. Return the list in any order.

	// efficient solution, inorder traversal.
	public List<Integer> getLonelyNodes(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		lonelyRec(root, result);
		return result;
	}

	public TreeNode lonelyRec(TreeNode root, List<Integer> result) {
		if (root == null) {
			return null;
		}
		TreeNode leftChild = lonelyRec(root.left, result);
		TreeNode rightChild = lonelyRec(root.right, result);
		if (leftChild != null && rightChild == null) {
			result.add(leftChild.data);
		}
		if (leftChild == null && rightChild != null) {
			result.add(rightChild.data);
		}
		return root;
	}

	// efficient solution, using preorder traversal.
	public List<Integer> getLonelyNodesPreOrder(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		lonelyRecPre(root, result);
		return result;
	}

	public void lonelyRecPre(TreeNode root, List<Integer> result) {
		if (root == null) {
			return;
		}
		if (root.left != null && root.right == null) {
			result.add(root.left.data);
		}
		if (root.left == null && root.right != null) {
			result.add(root.right.data);
		}
		lonelyRecPre(root.left, result);
		lonelyRecPre(root.right, result);
	}

}
