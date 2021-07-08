package com.algorithms.practice.tree;

public class PreorderSerializaAndDeserializeABinaryTree {

	// Serialization is the process of converting a data structure or object into a
	// sequence of bits so that it can be stored in a file or memory buffer, or
	// transmitted across a network connection link to be reconstructed later in the
	// same or another computer environment.

	// Design an algorithm to serialize and deserialize a binary tree. There is no
	// restriction on how your serialization/deserialization algorithm should work.
	// You just need to ensure that a binary tree can be serialized to a string and
	// this string can be deserialized to the original tree structure.

	// efficient solution.

	public StringBuilder sb = new StringBuilder();
	public int index = 1;

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return "";
		}
		serializeRec(root);
		return sb.toString();
	}

	// helper method for doing recursion in serialization.
	public void serializeRec(TreeNode root) {
		if (root == null) {
			sb.append("null,");
			return;
		}
		sb.append(root.data + ",");
		serializeRec(root.left);
		serializeRec(root.right);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data.equals("")) {
			return null;
		}
		data = data.substring(0, data.length() - 1);
		String[] sList = data.split(",");
		TreeNode root = new TreeNode(Integer.parseInt(sList[0]));
		deserializeRec(root, sList);
		return root;
	}

	// helper method for doing recursion in deserialization.
	public void deserializeRec(TreeNode root, String[] sList) {
		if (root == null) {
			return;
		}
		TreeNode leftChild = null;
		if (!sList[index].equals("null")) {
			leftChild = new TreeNode(Integer.parseInt(sList[index]));
		}
		root.left = leftChild;
		index++;
		deserializeRec(root.left, sList);
		TreeNode rightChild = null;
		if (!sList[index].equals("null")) {
			rightChild = new TreeNode(Integer.parseInt(sList[index]));
		}
		root.right = rightChild;
		index++;
		deserializeRec(root.right, sList);
	}
}
