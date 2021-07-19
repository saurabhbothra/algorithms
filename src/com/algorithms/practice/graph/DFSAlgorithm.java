package com.algorithms.practice.graph;

import java.util.ArrayList;
import java.util.List;

public class DFSAlgorithm {

	// Implement Depth First Search (DFS) Algorithm.

	// First Version: Given an undirected graph as a adjacency list, number of
	// vertices (1 - indexed) (v) and a source vertex (s), print DFS from the given
	// source vertex.

	public static List<Integer> dfs(List<List<Integer>> adj, int v, int s) {
		List<Integer> result = new ArrayList<>();
		if (adj == null || adj.size() == 0) {
			return result;
		}
		boolean[] visited = new boolean[v];
		dfsRec(adj, result, visited, 0);
		return result;
	}

	// helper method to do recursion for dfs.
	public static void dfsRec(List<List<Integer>> adj, List<Integer> result, boolean[] visited, int s) {
		result.add(s);
		visited[s] = true;
		List<Integer> childs = adj.get(s);
		for (int node : childs) {
			if (!visited[node]) {
				dfsRec(adj, result, visited, node);
			}
		}
	}

	// Second Version: No source given and graph may be disconnected.

	public static List<Integer> dfs(List<List<Integer>> adj, int v) {
		List<Integer> result = new ArrayList<>();
		if (adj == null || adj.size() == 0) {
			return result;
		}
		boolean[] visited = new boolean[v];
		for (int i = 0; i < v; i++) {
			if (!visited[i]) {
				List<Integer> res = new ArrayList<>();
				dfsImplRec(adj, res, visited, i);
				result.addAll(res);
			}
		}
		return result;
	}

	// helper method to do recursion for dfs.
	public static void dfsImplRec(List<List<Integer>> adj, List<Integer> result, boolean[] visited, int s) {
		result.add(s);
		visited[s] = true;
		List<Integer> childs = adj.get(s);
		for (int node : childs) {
			if (!visited[node]) {
				dfsImplRec(adj, result, visited, node);
			}
		}
	}

	// Variation of DFS: Count connected components in an undirected graph.
	// A component is called connected if a vertex is reachable from every other
	// vertex.

	public static int countConnectedComponents(List<List<Integer>> adj, int v) {
		if (adj == null || adj.size() == 0) {
			return 0;
		}
		int count = 0;
		boolean[] visited = new boolean[v];
		for (int i = 0; i < v; i++) {
			if (!visited[i]) {
				count++;
				dfsImplRec(adj, visited, i);
			}
		}
		return count;
	}

	// helper method to do recursion for dfs.
	public static void dfsImplRec(List<List<Integer>> adj, boolean[] visited, int s) {
		visited[s] = true;
		List<Integer> childs = adj.get(s);
		for (int node : childs) {
			if (!visited[node]) {
				dfsImplRec(adj, visited, node);
			}
		}
	}

}
