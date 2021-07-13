package com.algorithms.practice.bst;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.algorithms.practice.tree.TreeNode;

public class PairSumWithGivenBST {

	// Given the root of a Binary Search Tree and a target number k, return true if
	// there exist two elements in the BST such that their sum is equal to the given
	// target.

	Set<Integer> hset = new HashSet<>();
	List<Integer> result = new ArrayList<>();

	// naive solution.
	public boolean findTargetNaive(TreeNode root, int k) {
		inorder(root);
		int start = 0;
		int end = result.size() - 1;
		while (start < end) {
			int temp = result.get(start) + result.get(end);
			if (temp == k) {
				return true;
			}
			if (temp > k) {
				end--;
			} else {
				start++;
			}
		}
		return false;
	}

	// helper method to do iorder traversal.
	public void inorder(TreeNode root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		result.add(root.data);
		inorder(root.right);
	}

	// efficient solution.
	public boolean findTarget(TreeNode root, int k) {
		if (root == null) {
			return false;
		}
		int complement = k - root.data;
		if (hset.contains(complement)) {
			return true;
		}
		hset.add(root.data);
		return findTarget(root.left, k) || findTarget(root.right, k);
	}

}
