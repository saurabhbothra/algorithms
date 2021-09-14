package com.algorithms.practice.general;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.HashMap;

public class FirstUnique {

	// You have a queue of integers, you need to retrieve the first unique integer
	// in the queue.

	// At most 50000 calls will be made to showFirstUnique and add.

	public ArrayDeque<Integer> q;
	public Map<Integer, Boolean> hmap;

	// Initializes the object with the numbers in the queue.
	public FirstUnique(int[] nums) {
		this.q = new ArrayDeque<>();
		this.hmap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			this.add(nums[i]);
		}
	}

	// returns the value of the first unique integer of the queue, and returns -1 if
	// there is no such integer.
	public int showFirstUnique() {
		while (!q.isEmpty() && !hmap.get(q.peek())) {
			q.poll();
		}
		return q.size() == 0 ? -1 : q.peek();
	}

	// insert value to the queue.
	public void add(int value) {
		if (!hmap.containsKey(value)) {
			hmap.put(value, true);
			q.offer(value);
		} else {
			hmap.put(value, false);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 3, 5 };
		FirstUnique firstUnique = new FirstUnique(nums);
		System.out.println(firstUnique.showFirstUnique()); // return 2
		firstUnique.add(5); // the queue is now [2,3,5,5]
		System.out.println(firstUnique.showFirstUnique()); // return 2
		firstUnique.add(2); // the queue is now [2,3,5,5,2]
		System.out.println(firstUnique.showFirstUnique()); // return 3
		firstUnique.add(3); // the queue is now [2,3,5,5,2,3]
		System.out.println(firstUnique.showFirstUnique()); // return -1
	}

}
