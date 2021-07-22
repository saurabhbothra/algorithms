package com.algorithms.practice.graph;

import java.util.ArrayDeque;
import java.util.List;

public class TopologicalSortingDFS {

	// Given a directed acyclic graph (no cycles), we need to find topological
	// sorting of it. You can find any topological sort of the graph.

	// dfs based approach.
	public static int[] topologicalSort(List<List<Integer>> adj, int V) {
		if (adj == null || adj.size() == 0) {
			return new int[] {};
		}
		int[] result = new int[V];
		boolean[] visited = new boolean[V];
		int index = 0;
		ArrayDeque<Integer> st = new ArrayDeque<>();
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				dfsRec(adj, st, i, visited);
			}
		}
		while (!st.isEmpty()) {
			result[index] = st.pop();
			index++;
		}
		return result;
	}

	// helper method to do dfs using recursion.
	public static void dfsRec(List<List<Integer>> adj, ArrayDeque<Integer> st, int source, boolean[] visited) {
		visited[source] = true;
		List<Integer> childs = adj.get(source);
		for (Integer node : childs) {
			if (!visited[node]) {
				dfsRec(adj, st, node, visited);
			}
		}
		st.push(source);
	}
}
