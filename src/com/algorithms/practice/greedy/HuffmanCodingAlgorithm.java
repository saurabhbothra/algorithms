package com.algorithms.practice.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCodingAlgorithm {

	// Given an input array characters and their frequencies, encode the characters
	// and decode it back.

	// efficient implementation.
	public static Node buildHuffmanTree(char[] ch, int[] frequency) {
		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.freq, n2.freq));
		for (int i = 0; i < ch.length; i++) {
			pq.add(new Node(ch[i], frequency[i]));
		}
		while (pq.size() > 1) {
			Node left = pq.poll();
			Node right = pq.poll();
			Node root = new Node('$', left.freq + right.freq);
			root.left = left;
			root.right = right;
			pq.add(root);
		}
		return pq.poll();
	}

	// display encoded codes of each character.
	public static void display(Node root, String str) {
		if (root == null) {
			return;
		}
		if (root.c != '$') {
			System.out.println(root.c + " - " + str);
			return;
		}
		display(root.left, str + "0");
		display(root.right, str + "1");
	}

	// return the decoded string.
	public static String decodeHuffmanData(Node root, String binaryString) {
		Node curr = root;
		String res = "";
		for (int i = 0; i < binaryString.length(); i++) {
			Character c = binaryString.charAt(i);
			if (c == '0') {
				curr = curr.left;
			} else {
				curr = curr.right;
			}
			if (curr.left == null && curr.right == null) {
				res = res + curr.c;
				curr = root;
			}
		}
		return res;
	}
}

class Node {
	char c;
	int freq;
	Node left;
	Node right;

	Node(char c, int freq) {
		this.c = c;
		this.freq = freq;
		this.left = null;
		this.right = null;
	}
}
