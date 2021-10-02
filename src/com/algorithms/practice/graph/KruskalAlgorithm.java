package com.algorithms.practice.graph;

import java.util.Collections;
import java.util.List;

class Edge {
	int src;
	int des;
	int wt;

	Edge(int src, int des, int wt) {
		this.src = src;
		this.des = des;
		this.wt = wt;
	}
}

public class KruskalAlgorithm {

	// Implement Kruskal Algorithm to find MST.

	public int[] parent;
	public int[] rank;

	public void union(int x, int y) {
		int repX = find(x);
		int repY = find(y);
		if (repX == repY) {
			return;
		}
		if (rank[repX] > rank[repY]) {
			parent[repY] = repX;
		} else if (rank[repX] < rank[repY]) {
			parent[repX] = repY;
		} else {
			parent[repY] = repX;
			rank[repX] += 1;
		}
	}

	public int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		int rep = find(parent[x]);
		parent[x] = rep;
		return rep;
	}

	// Function to find the minimum spanning tree value using Kruskal.
	public long kruskalDSU(List<Edge> adj, int n, int m) {
		// add your code here
		Collections.sort(adj, (e1, e2) -> Integer.compare(e1.wt, e2.wt));
		int s = 0;
		long res = 0;
		this.parent = new int[n + 1];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		this.rank = new int[n + 1];
		for (int i = 0; s < n - 1; i++) {
			Edge e = adj.get(i);
			int a = find(e.src);
			int b = find(e.des);
			if (a != b) {
				res = res + e.wt;
				union(a, b);
				s++;
			}
		}
		return res;
	}

}
