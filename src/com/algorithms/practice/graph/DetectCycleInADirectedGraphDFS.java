package com.algorithms.practice.graph;

import java.util.List;

public class DetectCycleInADirectedGraphDFS {

	// Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges,
	// check whether it contains any cycle or not.

	// dfs based solution.
	public static boolean isCyclicDfs(List<List<Integer>> adj, int V) {
		if (adj == null || adj.size() == 0) {
			return false;
		}
		boolean[] visited = new boolean[V];
		boolean[] recStk = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				if (dfsRec(adj, visited, recStk, i)) {
					return true;
				}
			}
		}
		return false;
	}

	// helper method to do recursion for dfs.
	public static boolean dfsRec(List<List<Integer>> adj, boolean[] visited, boolean[] recStk, int source) {
		visited[source] = true;
		recStk[source] = true;
		List<Integer> childs = adj.get(source);
		for (Integer node : childs) {
			if (!visited[node]) {
				if (dfsRec(adj, visited, recStk, node)) {
					return true;
				}
			} else {
				if (recStk[node]) {
					return true;
				}
			}
		}
		recStk[source] = false;
		return false;
	}

}
