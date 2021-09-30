package com.algorithms.practice.general;

import java.util.ArrayList;
import java.util.List;

import com.algorithms.practice.tree.TreeNode;

// Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):

// Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest 
// element in the BST.

// You may assume that next() calls will always be valid. That is, there will be at least a next number in the 
// in-order traversal when next() is called.

public class BSTIterator {

	public List<Integer> inorderList;
	public int pointer;

	// Initializes an object of the BSTIterator class. The root of the BST is given
	// as part of the constructor. The pointer should be initialized to a
	// non-existent number smaller than any element in the BST.
	public BSTIterator(TreeNode root) {
		this.inorderList = new ArrayList<>();
		this.pointer = -1;
		inorder(root);
	}

	private void inorder(TreeNode root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		inorderList.add(root.data);
		inorder(root.right);
	}

	// Returns true if there exists a number in the traversal to the right of the
	// pointer, otherwise returns false.
	public int next() {
		pointer = pointer + 1;
		return inorderList.get(pointer);
	}

	// Moves the pointer to the right, then returns the number at the pointer.
	public boolean hasNext() {
		if (pointer + 1 == inorderList.size()) {
			return false;
		}
		return true;
	}
}
