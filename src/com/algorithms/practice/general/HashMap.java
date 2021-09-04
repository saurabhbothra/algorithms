package com.algorithms.practice.general;

import java.util.ArrayList;
import java.util.List;

public class HashMap {
	
	// Design a HashMap without using any built-in hash table libraries.
	
	private List<List<Bucket>> table;

	/** Initialize your data structure here. */
	public HashMap() {
		this.table = new ArrayList<>();
		for (int i = 0; i < 2069; i++) {
			this.table.add(new ArrayList<>());
		}
	}

	private int hash(int key) {
		return key % 2069;
	}

	private Bucket search(int key) {
		int i = this.hash(key);
		List<Bucket> buckets = this.table.get(i);
		for (Bucket b : buckets) {
			if (b.key == key) {
				return b;
			}
		}
		return null;
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		Bucket b = this.search(key);
		if (b == null) {
			int i = this.hash(key);
			this.table.get(i).add(new Bucket(key, value));
		} else {
			b.value = value;
		}
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map
	 * contains no mapping for the key
	 */
	public int get(int key) {
		Bucket b = this.search(key);
		if (b == null) {
			return -1;
		}
		return b.value;
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping
	 * for the key
	 */
	public void remove(int key) {
		Bucket b = this.search(key);
		if (b != null) {
			int i = this.hash(key);
			this.table.get(i).remove(b);
		}
	}
}

class Bucket {
	int key;
	int value;

	Bucket(int key, int value) {
		this.key = key;
		this.value = value;
	}
}
