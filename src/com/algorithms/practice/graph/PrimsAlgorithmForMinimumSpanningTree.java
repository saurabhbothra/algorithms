package com.algorithms.practice.graph;

import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithmForMinimumSpanningTree {

	// Given a weighted, undirected and connected graph of V vertices and E edges.
	// The task is to find the sum of weights of the edges of the Minimum Spanning
	// Tree.

	// prims algorithm, naive implementation with adjacency matrix.
	public static int mstPrimsNaive(int[][] graph, int V) {
		int[] key = new int[V];
		int res = 0;
		for (int i = 0; i < V; i++) {
			if (i == 0) {
				key[i] = 0;
			} else {
				key[i] = Integer.MAX_VALUE;
			}
		}
		boolean[] mstSet = new boolean[V];
		for (int count = 0; count < V; count++) {
			int u = -1;
			for (int i = 0; i < V; i++) {
				if (!mstSet[i] && (u == -1 || key[i] < key[u]))
					u = i;
			}
			mstSet[u] = true;
			res += key[u];
			for (int i = 0; i < V; i++) {
				if (!mstSet[i] && graph[u][i] != 0 && graph[u][i] < key[i])
					key[i] = graph[u][i];
			}
		}
		return res;
	}

	// prims algorithm, naive implementation with adjacency list.
	public static int mstPrims(List<List<List<Integer>>> adj, int V) {
		int[] key = new int[V];
		int res = 0;
		for (int i = 0; i < V; i++) {
			if (i == 0) {
				key[i] = 0;
			} else {
				key[i] = Integer.MAX_VALUE;
			}
		}
		boolean[] mstSet = new boolean[V];
		for (int count = 0; count < V; count++) {
			int u = -1;
			for (int i = 0; i < V; i++) {
				if (!mstSet[i] && (u == -1 || key[i] < key[u]))
					u = i;
			}
			mstSet[u] = true;
			res += key[u];
			List<List<Integer>> childs = adj.get(u);
			for (List<Integer> nodeDetails : childs) {
				int node = nodeDetails.get(0);
				int weight = nodeDetails.get(1);
				if (!mstSet[node] && weight < key[node])
					key[node] = weight;
			}
		}
		return res;
	}

	// prims algorithm, efficient implementation with min heap.
	public static int prims(List<List<List<Integer>>> adj, int V) {
		PriorityQueue<Node> key = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.weight, n2.weight));
		int res = 0;
		key.add(new Node(0, 0));
		boolean[] mstSet = new boolean[V];
		while (!key.isEmpty()) {
			Node poppedNode = key.poll();
			int u = poppedNode.data;
			if (mstSet[u]) {
				continue;
			}
			mstSet[u] = true;
			res += poppedNode.weight;
			List<List<Integer>> childs = adj.get(u);
			for (List<Integer> nodeDetails : childs) {
				int node = nodeDetails.get(0);
				int weight = nodeDetails.get(1);
				if (!mstSet[node])
					key.add(new Node(node, weight));
			}
		}
		return res;
	}

}

class Node {
	int data;
	int weight;

	Node(int data, int weight) {
		this.data = data;
		this.weight = weight;
	}
}
