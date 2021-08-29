package com.algorithms.practice.trie;

class BTrieNode {
	BTrieNode[] childs = new BTrieNode[2];
	boolean isEnd;
}

public class CountDistinctRowsInABinaryMatrix {

	// Given a binary matrix, count distinct rows in it.

	private BTrieNode root;
	public int count;

	public CountDistinctRowsInABinaryMatrix() {
		this.root = new BTrieNode();
		this.count = 0;
	}

	public void insert(int[] row) {
		if (row == null || row.length == 0) {
			return;
		}
		BTrieNode curr = this.root;
		for (int i = 0; i < row.length; i++) {
			if (curr.childs[row[i]] == null) {
				curr.childs[row[i]] = new BTrieNode();
			}
			curr = curr.childs[row[i]];
		}
		curr.isEnd = true;
	}

	public int countUniqueRows() {
		countRec(this.root);
		return count;
	}

	public void countRec(BTrieNode curr) {
		if (curr.isEnd) {
			this.count++;
			return;
		}
		for (int i = 0; i < curr.childs.length; i++) {
			if (curr.childs[i] != null) {
				countRec(curr.childs[i]);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountDistinctRowsInABinaryMatrix t = new CountDistinctRowsInABinaryMatrix();
		int[][] matrix = { { 1, 0, 0, 0 }, { 1, 1, 0, 0 }, { 1, 1, 0, 0 }, { 1, 1, 0, 1 } };
		for (int i = 0; i < matrix.length; i++) {
			t.insert(matrix[i]);
		}
		System.out.println("The number of distinct rows in the matrix is: " + t.countUniqueRows());
	}

}
