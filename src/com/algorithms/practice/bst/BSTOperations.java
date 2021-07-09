package com.algorithms.practice.bst;

import com.algorithms.practice.tree.TreeNode;

public class BSTOperations {

	// Implement operations of binary search tree.

	// recursive search operation in bst.
	public TreeNode searchBST(TreeNode root, int val) {
		if (root == null) {
			return null;
		}
		if (root.data == val) {
			return root;
		}
		if (val > root.data) {
			return searchBST(root.right, val);
		}
		return searchBST(root.left, val);
	}

	// iterative search operation in bst.
	public TreeNode searchBSTIterative(TreeNode root, int val) {
		while (root != null) {
			if (root.data == val) {
				return root;
			}
			if (val > root.data) {
				root = root.right;
			} else {
				root = root.left;
			}
		}
		return null;
	}

	// recursive insert operation in bst.
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}
		if (val > root.data) {
			root.right = insertIntoBST(root.right, val);
		} else {
			root.left = insertIntoBST(root.left, val);
		}
		return root;
	}

	// iterative insert operation in bst.
	public TreeNode insertIntoBSTIterative(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}
		TreeNode curr = root;
		TreeNode prev = root;
		while (curr != null) {
			prev = curr;
			if (val > curr.data) {
				curr = curr.right;
			} else {
				curr = curr.left;
			}
		}
		if (val > prev.data) {
			prev.right = new TreeNode(val);
		} else {
			prev.left = new TreeNode(val);
		}
		return root;
	}

	// recursive delete operation in bst.
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if (root.data == key) {
			TreeNode curr = findReplacement(root);
			if (curr != null) {
				curr.left = root.left;
				curr.right = root.right;
			}
			root = curr;
		} else if (key > root.data) {
			root.right = deleteNode(root.right, key);
		} else {
			root.left = deleteNode(root.left, key);
		}
		return root;
	}

	// iterative delete operation in bst.
	public TreeNode deleteNodeIterative(TreeNode root, int key) {
		TreeNode curr = root;
		TreeNode parent = null;
		while (curr != null) {
			if (curr.data == key) {
				TreeNode temp = findReplacement(curr);
				if (temp != null) {
					temp.left = curr.left;
					temp.right = curr.right;
					if (parent != null) {
						if (temp.data < parent.data) {
							parent.left = temp;
						} else {
							parent.right = temp;
						}
					}
				} else if (parent != null) {
					if (parent.left == curr) {
						parent.left = temp;
					} else {
						parent.right = temp;
					}
				}
				curr = temp;
				break;
			}
			parent = curr;
			if (key > curr.data) {
				curr = curr.right;
			} else {
				curr = curr.left;
			}
		}
		return (parent == null) ? curr : root;
	}

	// helper method to find replacement of node.
	public TreeNode findReplacement(TreeNode root) {
		TreeNode res = null;
		TreeNode parent = root;
		TreeNode curr = null;
		if (root.left != null) {
			curr = root.left;
			while (curr.right != null) {
				parent = curr;
				curr = curr.right;
			}
			if (parent == root) {
				parent.left = curr.left;
			} else {
				parent.right = curr.left;
			}
			res = curr;
		} else if (root.right != null) {
			curr = root.right;
			while (curr.left != null) {
				parent = curr;
				curr = curr.left;
			}
			if (parent == root) {
				parent.right = curr.right;
			} else {
				parent.left = curr.right;
			}
			res = curr;
		}
		return res;
	}

	// inorder bst traversal
	public void display(TreeNode root) {
		if (root == null) {
			return;
		}
		display(root.left);
		System.out.print(root.data + " ");
		display(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTOperations bst = new BSTOperations();
		TreeNode root = bst.insertIntoBSTIterative(null, 20);
		root = bst.insertIntoBSTIterative(root, 10);
		root = bst.insertIntoBSTIterative(root, 5);
		root = bst.insertIntoBSTIterative(root, 1);
		root = bst.insertIntoBSTIterative(root, 16);
		root = bst.insertIntoBSTIterative(root, 15);
		root = bst.insertIntoBSTIterative(root, 30);
		root = bst.insertIntoBSTIterative(root, 40);
		System.out.println("The inorder traversal of bst is: ");
		bst.display(root);
		System.out.println();
	}

}
