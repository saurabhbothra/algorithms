package com.algorithms.practice.graph;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectCycleInAnUndirectedGraph {

	// Given an undirected graph with V vertices and E edges, check whether it
	// contains any cycle or not.

	// bfs based approach.
	public static boolean detectCycle(List<List<Integer>> adj, int V) {
		if (adj == null || adj.size() == 0) {
			return false;
		}
		boolean[] visited = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				if (bfs(adj, i, visited)) {
					return true;
				}
			}
		}
		return false;
	}

	// helper method to do bfs.
	public static boolean bfs(List<List<Integer>> adj, int source, boolean[] visited) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		Map<Integer, Integer> hmap = new HashMap<>();
		visited[source] = true;
		q.offer(source);
		hmap.put(source, -1);
		while (!q.isEmpty()) {
			Integer poppedNode = q.poll();
			List<Integer> childs = adj.get(poppedNode);
			for (Integer node : childs) {
				if (!visited[node]) {
					visited[node] = true;
					hmap.put(node, poppedNode);
					q.offer(node);
				} else {
					if (node != hmap.get(poppedNode)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	// dfs based approach
	public static boolean detectCycleDfs(List<List<Integer>> adj, int V) {
		if (adj == null || adj.size() == 0) {
			return false;
		}
		boolean[] visited = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				if (dfsRec(adj, visited, i, -1)) {
					return true;
				}
			}
		}
		return false;
	}

	// helper method to do recursion for dfs.
	public static boolean dfsRec(List<List<Integer>> adj, boolean[] visited, int source, int parent) {
		visited[source] = true;
		List<Integer> childs = adj.get(source);
		for (Integer node : childs) {
			if (!visited[node]) {
				if (dfsRec(adj, visited, node, source)) {
					return true;
				}
			} else {
				if (node != parent) {
					return true;
				}
			}
		}
		return false;
	}

}
