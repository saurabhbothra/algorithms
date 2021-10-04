package com.algorithms.practice.general;

import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class LTrieNode {
	String name;
	boolean isFolder;
	StringBuilder content;
	Map<String, LTrieNode> childs;

	LTrieNode(String name, boolean isFolder) {
		this.name = name;
		this.content = new StringBuilder();
		this.isFolder = isFolder;
		this.childs = new HashMap<>();
	}
}

// Design a data structure that simulates an in-memory file system.

// 1 <= path.length, filePath.length <= 100
// path and filePath are absolute paths which begin with '/' and do not end with '/' except that the path is just "/".
// You can assume that all directory names and file names only contain lowercase letters, and the same names will not exist in the same directory.
// You can assume that all operations will be passed valid parameters, and users will not attempt to retrieve file content or list a directory or file that does not exist.
// 1 <= content.length <= 50
// At most 300 calls will be made to ls, mkdir, addContentToFile, and readContentFromFile.

public class InMemoryFileSystem {

	public LTrieNode root;

	// Initializes the object of the system.
	public InMemoryFileSystem() {
		this.root = new LTrieNode("/", true);
	}

	/*
	 * If path is a file path, returns a list that only contains this file's name.
	 * If path is a directory path, returns the list of file and directory names in
	 * this directory. The answer should in lexicographic order.
	 */
	public List<String> ls(String path) {
		List<String> result = new ArrayList<>();
		String[] paths = path.split("/");
		LTrieNode curr = this.root;
		for (int i = 1; i < paths.length; i++) {
			curr = curr.childs.get(paths[i]);
		}
		if (!curr.isFolder) {
			result.add(curr.name);
		} else {
			for (String k : curr.childs.keySet()) {
				result.add(k);
			}
			Collections.sort(result);
		}
		return result;
	}

	// Makes a new directory according to the given path. The given directory path
	// does not exist. If the middle directories in the path do not exist, you
	// should create them as well.
	public void mkdir(String path) {
		String[] paths = path.split("/");
		LTrieNode curr = this.root;
		for (int i = 1; i < paths.length; i++) {
			if (!curr.childs.containsKey(paths[i])) {
				curr.childs.put(paths[i], new LTrieNode(paths[i], true));
			}
			curr = curr.childs.get(paths[i]);
		}
	}

	// If filePath does not exist, creates that file containing given content.
	// If filePath already exists, appends the given content to original content.
	public void addContentToFile(String filePath, String content) {
		String[] paths = filePath.split("/");
		LTrieNode curr = this.root;
		for (int i = 1; i < paths.length; i++) {
			if (!curr.childs.containsKey(paths[i])) {
				curr.childs.put(paths[i], new LTrieNode(paths[i], true));
			}
			curr = curr.childs.get(paths[i]);
		}
		curr.isFolder = false;
		curr.content.append(content);
	}

	// Returns the content in the file at filePath.
	public String readContentFromFile(String filePath) {
		String[] paths = filePath.split("/");
		LTrieNode curr = this.root;
		for (int i = 1; i < paths.length; i++) {
			curr = curr.childs.get(paths[i]);
		}
		return curr.content.toString();
	}

}
