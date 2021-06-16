package com.algorithms.practice.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheUsingArray {

	// Design a data structure that follows the constraints of a Least Recently Used
	// (LRU) cache.

	public int[] nums;
	public Map<Integer, Integer> hmap;
	public int size;

	// Initialize the LRU cache with positive size capacity.
	public LRUCacheUsingArray(int capacity) {
		this.nums = new int[capacity];
		this.size = 0;
		hmap = new HashMap<>();
	}

	// Return the value of the key if the key exists, otherwise return -1.
	public int get(int key) {
		if (!hmap.containsKey(key)) {
			return -1;
		}
		this.reshuffleArray(key);
		return hmap.get(key);
	}

	// Update the value of the key if the key exists. Otherwise, add the key-value
	// pair to the cache. If the number of keys exceeds the capacity from this
	// operation, evict the least recently used key.
	public void put(int key, int value) {
		if (hmap.containsKey(key)) {
			reshuffleArray(key);
		} else {
			int index = -1;
			if (this.size == this.nums.length - 1) {
				this.hmap.remove(nums[this.size]);
				index = this.size;
			} else {
				index = this.size + 1;
				this.size++;
			}
			this.shiftArray(index, key);
		}
		hmap.put(key, value);
	}

	// helper method to find the index of key and shift the key to first position.
	private void reshuffleArray(int key) {
		int index = -1;
		for (int i = 0; i <= this.size; i++) {
			if (this.nums[i] == key) {
				index = i;
				break;
			}
		}
		this.shiftArray(index, key);
	}

	// helper method to shift the key to the first position in array.
	private void shiftArray(int index, int key) {
		while (index > 0) {
			index--;
			this.nums[index + 1] = this.nums[index];
		}
		this.nums[0] = key;
	}
}
