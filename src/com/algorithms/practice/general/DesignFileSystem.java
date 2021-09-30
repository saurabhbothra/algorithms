package com.algorithms.practice.general;

import java.util.Map;
import java.util.HashMap;

class HTrieNode {
	Map<String, HTrieNode> hmap = new HashMap<>();
	Integer value;
}

public class DesignFileSystem {

	// You are asked to design a file system that allows you to create new paths and
	// associate them with different values.

	// The format of a path is one or more concatenated strings of the form: /
	// followed by one or more lowercase English letters. For example, "/leetcode"
	// and "/leetcode/problems" are valid paths while an empty string "" and "/" are
	// not.

	public HTrieNode root;

	public DesignFileSystem() {
		this.root = new HTrieNode();
	}

	public boolean createPath(String path, int value) {
		if (path.equals("") || path.equals("/")) {
			return false;
		}
		HTrieNode curr = this.root;
		String[] paths = path.split("/");
		for (int i = 1; i < paths.length - 1; i++) {
			if (!curr.hmap.containsKey(paths[i])) {
				return false;
			}
			curr = curr.hmap.get(paths[i]);
		}
		if (curr.hmap.containsKey(paths[paths.length - 1])) {
			return false;
		} else {
			curr.hmap.put(paths[paths.length - 1], new HTrieNode());
		}
		curr = curr.hmap.get(paths[paths.length - 1]);
		curr.value = value;
		return true;
	}

	public int get(String path) {
		if (path.equals("") || path.equals("/")) {
			return -1;
		}
		HTrieNode curr = this.root;
		String[] paths = path.split("/");
		for (int i = 1; i < paths.length; i++) {
			if (!curr.hmap.containsKey(paths[i])) {
				return -1;
			}
			curr = curr.hmap.get(paths[i]);
		}
		return curr.value;
	}

}
