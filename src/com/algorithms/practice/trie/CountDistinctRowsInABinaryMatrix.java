package com.algorithms.practice.trie;

class BTrieNode {
	BTrieNode[] childs = new BTrieNode[2];
}

public class CountDistinctRowsInABinaryMatrix {

	// Given a binary matrix, count distinct rows in it.

	private BTrieNode root;

	public CountDistinctRowsInABinaryMatrix() {
		this.root = new BTrieNode();
	}

	public boolean insert(int[] row) {
		BTrieNode curr = this.root;
		boolean isDistinct = false;
		for (int i = 0; i < row.length; i++) {
			if (curr.childs[row[i]] == null) {
				curr.childs[row[i]] = new BTrieNode();
				isDistinct = true;
			}
			curr = curr.childs[row[i]];
		}
		return isDistinct;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountDistinctRowsInABinaryMatrix t = new CountDistinctRowsInABinaryMatrix();
		int[][] matrix = { { 1, 0, 0, 0 }, { 1, 1, 0, 0 }, { 1, 1, 0, 0 }, { 1, 1, 0, 1 } };
		int count = 0;
		for (int i = 0; i < matrix.length; i++) {
			if (t.insert(matrix[i])) {
				count++;
			}
		}
		System.out.println("The number of distinct rows in the matrix is: " + count);
	}

}
