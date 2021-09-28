package com.algorithms.practice.tree;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

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
		if (root == null) {
			return "";
		}
		TreeNode dummy = new TreeNode(-1);
		StringBuilder sb = new StringBuilder();
		Set<TreeNode> hset = new HashSet<>();
		ArrayDeque<TreeNode> q = new ArrayDeque<>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			hset = new HashSet<>();
			for (int i = 0; i < size; i++) {
				TreeNode poppedNode = q.poll();
				if (poppedNode == dummy) {
					sb.append("null,");
					continue;
				} else {
					sb.append(poppedNode.data + ",");
				}
				TreeNode left = (poppedNode.left == null) ? dummy : poppedNode.left;
				TreeNode right = (poppedNode.right == null) ? dummy : poppedNode.right;
				q.offer(left);
				q.offer(right);
				hset.add(left);
				hset.add(right);
			}
			if (hset.size() == 1 && hset.contains(dummy)) {
				break;
			}
		}
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data.equals("")) {
			return null;
		}
		String[] nodes = data.split(",");
		TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
		ArrayDeque<TreeNode> q = new ArrayDeque<>();
		q.add(root);
		int i = 1;
		while (i < nodes.length) {
			TreeNode node = q.poll();
			if (!nodes[i].equals("null")) {
				node.left = new TreeNode(Integer.parseInt(nodes[i]));
				q.offer(node.left);
			}
			i++;
			if (!nodes[i].equals("null")) {
				node.right = new TreeNode(Integer.parseInt(nodes[i]));
				q.offer(node.right);
			}
			i++;
		}
		return root;
	}

}
