package com.algorithms.practice.segmentandbinaryindexedtree;

public class PrefixSumBTree {

	// Given an integer array nums, handle multiple queries of the following types:

	// Update the value of an element in nums.

	// Calculate the sum of the elements of nums between indices left and right
	// inclusive where left <= right.

	public int[] nums;
	public int[] bTree;

	// initialize your data structure here.
	public PrefixSumBTree(int[] nums) {
		this.nums = nums;
		this.bTree = new int[nums.length + 1];
		this.constructBTree();
	}

	// updates the value of nums[index] to be val.
	public void update(int index, int val) {
		int diff = val - this.nums[index];
		this.nums[index] = val;
		int i = index + 1;
		while (i < this.bTree.length) {
			this.bTree[i] = this.bTree[i] + diff;
			i = i + (i & (-i));
		}
	}

	// returns the sum of the elements of nums between indices left and right
	// inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
	public int sumRange(int left, int right) {
		int sum = this.getSum(right);
		if (left != 0) {
			sum = sum - this.getSum(left - 1);
		}
		return sum;
	}

	private int getSum(int i) {
		i = i + 1;
		int sum = 0;
		while (i > 0) {
			sum += this.bTree[i];
			i = i - (i & (-i));
		}
		return sum;
	}

	private void constructBTree() {
		for (int i = 0; i < this.nums.length; i++) {
			int j = i + 1;
			while (j < this.bTree.length) {
				this.bTree[j] = this.bTree[j] + this.nums[i];
				j = j + (j & (-j));
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 3, 5 };
		PrefixSumBTree rsq = new PrefixSumBTree(nums);
		System.out.println(rsq.sumRange(0, 2));
		rsq.update(1, 2);
		System.out.println(rsq.sumRange(0, 2));
	}

}
