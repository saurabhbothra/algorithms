package com.algorithms.practice.disjointset;

public class DisjointSet {

	// simple implementation of union and find operations.

	public int[] parent;

	public DisjointSet(int n) {
		this.parent = new int[n];
		for (int i = 0; i < n; i++) {
			this.parent[i] = i;
		}
	}

	public void union(int x, int y) {
		int xParent = this.find(x);
		int yParent = this.find(y);
		if (xParent == yParent) {
			return;
		}
		this.parent[yParent] = xParent;
	}

	public int find(int x) {
		if (this.parent[x] == x) {
			return x;
		}
		return this.find(this.parent[x]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DisjointSet ds = new DisjointSet(5);
		ds.union(0, 2);
		ds.union(2, 4);
		System.out.println(ds.find(0) == ds.find(2));
		System.out.println(ds.find(2) == ds.find(4));
		System.out.println(ds.find(0) == ds.find(3));
	}

}
