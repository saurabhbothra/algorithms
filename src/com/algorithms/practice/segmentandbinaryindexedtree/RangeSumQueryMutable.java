package com.algorithms.practice.segmentandbinaryindexedtree;

public class RangeSumQueryMutable {

	// Given an integer array nums, handle multiple queries of the following types:

	// Update the value of an element in nums.

	// Calculate the sum of the elements of nums between indices left and right
	// inclusive where left <= right.

	// 1 <= nums.length <= 3 * 10^4
	// -100 <= nums[i] <= 100
	// 0 <= index < nums.length
	// -100 <= val <= 100
	// 0 <= left <= right < nums.length
	// At most 3 * 10^4 calls will be made to update and sumRange.

	public int[] nums;
	public int[] segmentTree;

	// initializes the object with the integer array nums.
	public RangeSumQueryMutable(int[] nums) {
		this.nums = nums;
		this.segmentTree = new int[4 * nums.length];
		this.constructRec(0, nums.length - 1, 0);
	}

	// updates the value of nums[index] to be val.
	public void update(int index, int val) {
		this.nums[index] = val;
		updateRec(index, val, 0, this.nums.length - 1, 0);
	}

	private int updateRec(int index, int val, int ss, int se, int si) {
		if (ss == index && se == index) {
			int diff = val - this.segmentTree[si];
			this.segmentTree[si] = val;
			return diff;
		}
		int mid = ss + (se - ss) / 2;
		int diff = -1;
		if (index <= mid) {
			diff = updateRec(index, val, ss, mid, 2 * si + 1);
		} else {
			diff = updateRec(index, val, mid + 1, se, 2 * si + 2);
		}
		this.segmentTree[si] += diff;
		return diff;
	}

	// returns the sum of the elements of nums between indices left and right
	// inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
	public int sumRange(int left, int right) {
		return rangeRec(left, right, 0, this.nums.length - 1, 0);
	}

	private int rangeRec(int qs, int qe, int ss, int se, int si) {
		if (se < qs || qe < ss) {
			return 0;
		}
		if (qs <= ss && qe >= se) {
			return this.segmentTree[si];
		}
		int mid = ss + (se - ss) / 2;
		return rangeRec(qs, qe, ss, mid, si * 2 + 1) + rangeRec(qs, qe, mid + 1, se, si * 2 + 2);
	}

	private int constructRec(int start, int end, int index) {
		if (start == end) {
			this.segmentTree[index] = this.nums[start];
			return this.nums[start];
		}
		int mid = start + (end - start) / 2;
		int leftSum = constructRec(start, mid, 2 * index + 1);
		int rightSum = constructRec(mid + 1, end, 2 * index + 2);
		this.segmentTree[index] = leftSum + rightSum;
		return leftSum + rightSum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 3, 5 };
		RangeSumQueryMutable rsq = new RangeSumQueryMutable(nums);
		System.out.println(rsq.sumRange(0, 2));
		rsq.update(1, 2);
		System.out.println(rsq.sumRange(0, 2));
	}

}
