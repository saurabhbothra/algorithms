package com.algorithms.practice.general;

import java.util.Map;
import java.util.HashMap;

public class TwoSum3 {

	// Design a data structure that accepts a stream of integers and checks if it
	// has a pair of integers that sum up to a particular value.
	// At most 10^4 calls will be made to add and find.

	private Map<Integer, Integer> hmap;

	/** Initialize your data structure here. */
	public TwoSum3() {
		this.hmap = new HashMap<>();
	}

	/** Add the number to an internal data structure.. */
	public void add(int number) {
		if (hmap.containsKey(number)) {
			hmap.put(number, hmap.get(number) + 1);
		} else {
			hmap.put(number, 1);
		}
	}

	/** Find if there exists any pair of numbers which sum is equal to the value. */
	public boolean find(int value) {
		for (Map.Entry<Integer, Integer> entry : this.hmap.entrySet()) {
			int complement = value - entry.getKey();
			if (hmap.containsKey(complement)) {
				if (complement == entry.getKey() && hmap.get(complement) > 1) {
					return true;
				}
				if (complement != entry.getKey()) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoSum3 ts = new TwoSum3();
		ts.add(1);
		ts.add(3);
		ts.add(5);
		System.out.println(ts.find(8));
	}

}
