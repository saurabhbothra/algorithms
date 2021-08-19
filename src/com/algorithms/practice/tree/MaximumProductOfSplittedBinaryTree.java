package com.algorithms.practice.tree;

import java.util.ArrayList;
import java.util.List;

public class MaximumProductOfSplittedBinaryTree {

	// Given the root of a binary tree, split the binary tree into two subtrees by
	// removing one edge such that the product of the sums of the subtrees is
	// maximized.

	// Return the maximum product of the sums of the two subtrees. Since the answer
	// may be too large, return it modulo 10^9 + 7.

	// Note that you need to maximize the answer before taking the mod and not after
	// taking it.

	// The number of nodes in the tree is in the range [2, 5 * 10^4].
	// 1 <= Node.val <= 10^4.

	// efficient solution 1.
	public long maxProduct = 0;

	public int maxProduct(TreeNode root) {
		long totalSum = getTotalSum(root);
		productRec(root, totalSum);
		return (int) (maxProduct % 1000000007);
	}

	public long productRec(TreeNode root, long totalSum) {
		if (root == null) {
			return 0;
		}
		long leftEdgeSum = productRec(root.left, totalSum);
		maxProduct = Math.max(maxProduct, leftEdgeSum * (totalSum - leftEdgeSum));
		long rightEdgeSum = productRec(root.right, totalSum);
		maxProduct = Math.max(maxProduct, rightEdgeSum * (totalSum - rightEdgeSum));
		return root.data + leftEdgeSum + rightEdgeSum;
	}

	public long getTotalSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		long sum = root.data;
		sum = sum + getTotalSum(root.left);
		sum = sum + getTotalSum(root.right);
		return sum;
	}

	// efficient solution 2.
	public int maxProductSol(TreeNode root) {
		long maxProduct = 0;
		List<Long> result = new ArrayList<>();
		long totalSum = productRec(root, result);
		for (Long res : result) {
			maxProduct = Math.max(maxProduct, res * (totalSum - res));
		}
		return (int) (maxProduct % 1000000007);
	}

	public long productRec(TreeNode root, List<Long> result) {
		if (root == null) {
			return 0;
		}
		long leftEdgeSum = productRec(root.left, result);
		if (leftEdgeSum != 0) {
			result.add(leftEdgeSum);
		}
		long rightEdgeSum = productRec(root.right, result);
		if (rightEdgeSum != 0) {
			result.add(rightEdgeSum);
		}
		return root.data + leftEdgeSum + rightEdgeSum;
	}

}
