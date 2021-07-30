package com.algorithms.practice.graph;

import java.util.List;

public class BridgesInGraph {

	// Given an undirected graph of V vertices and E edges, the task is to print all
	// bridges in graph.

	// efficient implementation.
	public static void printBridges(List<List<Integer>> adj, int V, int c, int d) {
		boolean[] visited = new boolean[V];
		int[] parent = new int[V];
		int[] discoveryTimes = new int[V];
		int[] lowValues = new int[V];
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				parent[i] = -1;
				int timer = 1;
				dfsRec(adj, visited, parent, discoveryTimes, lowValues, timer, i);
			}
		}
	}

	// helper method to do recursion for dfs.
	public static void dfsRec(List<List<Integer>> adj, boolean[] visited, int[] parent, int[] discoveryTimes,
			int[] lowValues, int timer, int source) {
		visited[source] = true;
		discoveryTimes[source] = timer;
		lowValues[source] = timer;
		timer++;
		List<Integer> childs = adj.get(source);
		for (Integer node : childs) {
			if (!visited[node]) {
				parent[node] = source;
				dfsRec(adj, visited, parent, discoveryTimes, lowValues, timer, node);
				lowValues[source] = Math.min(lowValues[source], lowValues[node]);
				if (lowValues[node] > discoveryTimes[source]) {
					System.out.println(source + "-" + node);
				}
			} else if (visited[node] && node != parent[source]) {
				lowValues[source] = Math.min(lowValues[source], discoveryTimes[node]);
			}
		}
	}

}
