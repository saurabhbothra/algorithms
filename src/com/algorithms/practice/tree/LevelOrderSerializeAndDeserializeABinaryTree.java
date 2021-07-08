package com.algorithms.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSerializeAndDeserializeABinaryTree {

	// Serialization is the process of converting a data structure or object into a
	// sequence of bits so that it can be stored in a file or memory buffer, or
	// transmitted across a network connection link to be reconstructed later in the
	// same or another computer environment.

	// Design an algorithm to serialize and deserialize a binary tree. There is no
	// restriction on how your serialization/deserialization algorithm should work.
	// You just need to ensure that a binary tree can be serialized to a string and
	// this string can be deserialized to the original tree structure.

	// efficient solution.

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder serializedString = new StringBuilder();
		if (root == null) {
			return "";
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int count = q.size();
			for (int i = 0; i < count; i++) {
				TreeNode poppedNode = q.poll();
				if (poppedNode == null) {
					serializedString.append("null,");
					continue;
				}
				serializedString.append(poppedNode.data + ",");
				q.add(poppedNode.left);
				q.add(poppedNode.right);
			}
		}
		return serializedString.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data.equals("")) {
			return null;
		}
		data = data.substring(0, data.length() - 1);
		String[] sList = data.split(",");
		Queue<TreeNode> q = new LinkedList<>(); 
		TreeNode root = new TreeNode(Integer.parseInt(sList[0]));
		q.add(root);
		for (int i = 1; i < sList.length; i++) {
			TreeNode poppedNode = q.poll();
			if (!sList[i].equals("null")) {
				TreeNode leftNode = new TreeNode(Integer.parseInt(sList[i]));
				poppedNode.left = leftNode;
				q.add(leftNode);
			}
			i++;
			if (!sList[i].equals("null")) {
				TreeNode rightNode = new TreeNode(Integer.parseInt(sList[i]));
				poppedNode.right = rightNode;
				q.add(rightNode);
			}
		}
		return root;
	}

}
