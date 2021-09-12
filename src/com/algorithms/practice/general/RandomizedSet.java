package com.algorithms.practice.general;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.HashMap;
import java.util.ArrayList;

public class RandomizedSet {

	// You must implement the functions of the class such that each function works
	// in average O(1) time complexity.
	// There will be at least one element in the data structure when getRandom is
	// called.

	public List<Integer> numList;
	public Map<Integer, Integer> hmap;
	public Random rand;

	/** Initialize your data structure here. */
	public RandomizedSet() {
		this.numList = new ArrayList<>();
		this.hmap = new HashMap<>();
		this.rand = new Random();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {
		if (this.hmap.containsKey(val)) {
			return false;
		}
		this.hmap.put(val, this.numList.size());
		this.numList.add(val);
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 */
	public boolean remove(int val) {
		if (!this.hmap.containsKey(val)) {
			return false;
		}
		int index = this.hmap.get(val);
		int element = this.numList.get(this.numList.size() - 1);
		this.hmap.put(element, index);
		this.numList.set(index, element);
		this.numList.remove(this.numList.size() - 1);
		this.hmap.remove(val);
		return true;
	}

	// Returns a random element from the current set of elements (it's guaranteed
	// that at least one element exists when this method is called). Each element
	// must have the same probability of being returned.
	/** Get a random element from the set. */
	public int getRandom() {
		return this.numList.get(this.rand.nextInt(this.numList.size()));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomizedSet randomizedSet = new RandomizedSet();
		System.out.println(randomizedSet.insert(1));
		System.out.println(randomizedSet.remove(2));
		System.out.println(randomizedSet.insert(2));
		System.out.println(randomizedSet.getRandom());
		System.out.println(randomizedSet.remove(1));
		System.out.println(randomizedSet.getRandom());
	}

}
