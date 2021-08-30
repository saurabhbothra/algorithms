package com.algorithms.practice.disjointset;

public class DisjointSetPathCompression {

	// implement union and find using path compression technique and rank.

	private int[] parent;
	private int[] rank;

	public DisjointSetPathCompression(int n) {
		this.parent = new int[n];
		this.rank = new int[n];
		for (int i = 0; i < n; i++) {
			this.parent[i] = i;
		}
	}

	public void union(int x, int y) {
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
		int rep = this.find(this.parent[x]);
		this.parent[x] = rep;
		return rep;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DisjointSetPathCompression ds = new DisjointSetPathCompression(5);
		ds.union(0, 2);
		ds.union(2, 4);
		System.out.println(ds.find(0) == ds.find(2));
		System.out.println(ds.find(2) == ds.find(4));
		System.out.println(ds.find(0) == ds.find(3));
	}

}
