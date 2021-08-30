package com.algorithms.practice.disjointset;

public class DisjointSetRank {

	// implement union by rank.

	private int[] parent;
	private int[] rank;

	public DisjointSetRank(int n) {
		this.parent = new int[n];
		this.rank = new int[n];
		for (int i = 0; i < n; i++) {
			this.parent[i] = i;
		}
	}

	public void unionByRank(int x, int y) {
		int xRep = this.find(x);
		int yRep = this.find(y);
		if (xRep == yRep) {
			return;
		}
		if (this.rank[xRep] < this.rank[yRep]) {
			this.parent[xRep] = yRep;
		} else if (this.rank[xRep] > this.rank[yRep]) {
			this.parent[yRep] = xRep;
		} else {
			this.parent[yRep] = xRep;
			this.rank[xRep] += 1;
		}
	}

	public int find(int x) {
		if (this.parent[x] == x) {
			return x;
		}
		return this.find(this.parent[x]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DisjointSetRank ds = new DisjointSetRank(5);
		ds.unionByRank(0, 2);
		ds.unionByRank(2, 4);
		System.out.println(ds.find(0) == ds.find(2));
		System.out.println(ds.find(2) == ds.find(4));
		System.out.println(ds.find(0) == ds.find(3));
	}

}
