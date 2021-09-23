package com.algorithms.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.algorithms.practice.linkedlist.DoubleNode;
import com.algorithms.practice.linkedlist.Node;

// class for doing rough work.

public class demo {

	public int inverseMemo(int[] nums, int k) {
		Integer[][] memo = new Integer[k + 1][nums.length + 1];
		return inversionRec(nums, k, 0, memo);
	}

	public int inversionRec(int[] nums, int k, int index, Integer[][] memo) {
		if (k == 1) {
			memo[k][index] = 1;
		} else if (index == nums.length) {
			memo[k][index] = 0;
		}
		if (memo[k][index] == null) {
			int count = 0;
			for (int i = index + 1; i < nums.length; i++) {
				if (nums[index] > nums[i]) {
					count = count + inversionRec(nums, k - 1, i, memo);
				}
			}
			if (k == 3) {
				count = count + inversionRec(nums, k, index + 1, memo);
			}
			memo[k][index] = count;
		}
		return memo[k][index];
	}

	public int inversionTabulation(int[] nums, int k) {
		int[][] dp = new int[k + 1][nums.length + 1];
		for (int i = 0; i <= nums.length; i++) {
			dp[1][i] = 1;
		}
		for (int i = 2; i <= k; i++) {
			for (int j = nums.length - 1; j >= 0; j--) {
				int count = 0;
				for (int a = j + 1; a < nums.length; a++) {
					if (nums[j] > nums[a]) {
						count = count + dp[i - 1][a];
					}
				}
				if (i == 3) {
					count = count + dp[i][j + 1];
				}
				dp[i][j] = count;
			}
		}
		return dp[k][0];
	}

	public static void countDistinctElements(int[] nums, int k) {
		Map<Integer, Integer> hmap = new HashMap<>();
		for (int i = 0; i < k; i++) {
			hmap.put(nums[i], hmap.getOrDefault(nums[i], 0) + 1);
		}
		System.out.print(hmap.size() + " ");
		for (int i = k; i < nums.length; i++) {
			if (hmap.get(nums[i - k]) == 1) {
				hmap.remove(nums[i - k]);
			} else {
				hmap.put(nums[i - k], hmap.get(nums[i - k]) - 1);
			}
			hmap.put(nums[i], hmap.getOrDefault(nums[i], 0) + 1);
			System.out.print(hmap.size() + " ");
		}
	}

	public int abc(List<Integer> counters) {
		int oper = 0;
		int maxVal = Integer.MIN_VALUE;
		Set<Integer> hset = new HashSet<>();
		int maxIndex = -1;
		for (int i = 0; i < counters.size(); i++) {
			hset.add(counters.get(i));
			if (counters.get(i) > maxVal) {
				maxVal = counters.get(i);
				maxIndex = i;
			}
		}

		while (hset.size() > 1) {
			oper++;
			hset = new HashSet<>();
			int currMax = maxVal;
			int currIndex = maxIndex;
			for (int i = 0; i < counters.size(); i++) {
				if (i != maxIndex) {
					int temp = counters.get(i);
					counters.set(i, temp + 1);
				}
				if (counters.get(i) > currMax) {
					currMax = counters.get(i);
					currIndex = i;
				}
				hset.add(counters.get(i));
			}
			maxVal = currMax;
			maxIndex = currIndex;

		}
		
		
		return oper;

	}
	
	public static DoubleNode reverse(DoubleNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		DoubleNode prev = null;
		DoubleNode curr = head;
		while(curr!= null) {
			DoubleNode temp = curr.next;
			curr.next = prev;
			if(prev != null) {
				prev.prev = curr;
			}
			prev = curr;
			curr = temp;
		}
		return prev;
	}

	public static void main(String[] args) {
		// int[] nums = { 6, 5, 4, 3, 2, 1 };
		// int[] nums1 = { 5, 5, 2, 2, 1 };
		demo d = new demo();
		List<Integer> counters = new ArrayList<>();
		counters.add(3);
		counters.add(4);
		counters.add(6);
		counters.add(6);
		counters.add(3);
		System.out.println(d.abc(counters));

	}
}
