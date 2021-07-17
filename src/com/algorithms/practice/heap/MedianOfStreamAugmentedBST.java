package com.algorithms.practice.heap;

public class MedianOfStreamAugmentedBST {

	// The median is the middle value in an ordered integer list. If the size of the
	// list is even, there is no middle value and the median is the mean of the two
	// middle values.

	// Implement the MedianOfStream class.

	// Follow up:
	// If all integer numbers from the stream are in the range [0, 100], how would
	// you optimize your solution?

	// If 99% of all integer numbers from the stream are in the range [0, 100], how
	// would you optimize your solution?

	public TreeNode root;
	public int size;

	/** initialize your data structure here. */
	public MedianOfStreamAugmentedBST() {
		this.root = null;
		this.size = 0;
	}

	// adds the integer num from the data stream to the data structure.
	public void addNum(int num) {
		if (this.root == null) {
			this.root = new TreeNode(num);
		} else {
			TreeNode curr = this.root;
			TreeNode prev = this.root;
			while (curr != null) {
				prev = curr;
				if (num > curr.data) {
					curr = curr.right;
				} else {
					prev.leftCount = prev.leftCount + 1;
					curr = curr.left;
				}
			}
			if (num > prev.data) {
				prev.right = new TreeNode(num);
			} else {
				prev.left = new TreeNode(num);
			}
		}
		this.size++;
	}

	// returns the median of all elements so far. Answers within 10-5 of the actual
	// answer will be accepted.
	public double findMedian() {
		int k = (this.size / 2) + 1;
		if (this.size % 2 != 0) {
			return this.findMedianRec(this.root, k);
		}
		return (this.findMedianRec(this.root, k) + this.findMedianRec(this.root, k - 1)) / 2.0;
	}

	// helper method to find median.
	public int findMedianRec(TreeNode node, int k) {
		if (k == node.leftCount + 1) {
			return node.data;
		}
		if (k < node.leftCount + 1) {
			return findMedianRec(node.left, k);
		}
		return findMedianRec(node.right, k - (node.leftCount + 1));
	}
}

class TreeNode {
	int data;
	int leftCount;
	TreeNode left;
	TreeNode right;

	TreeNode(int data) {
		this.data = data;
		this.leftCount = 0;
		this.left = null;
		this.right = null;
	}
}
