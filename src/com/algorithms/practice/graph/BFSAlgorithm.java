package com.algorithms.practice.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BFSAlgorithm {

	// Implement Breadth First Search (BFS) Algorithm.

	// First Version: Given an undirected graph as a adjacency list, number of
	// vertices (1 - indexed) (v) and a source vertex (s), print BFS from the given
	// source vertex.

	public static List<Integer> bfs(List<List<Integer>> adj, int v, int s) {
		List<Integer> result = new ArrayList<>();
		if (adj == null || adj.size() == 0) {
			return result;
		}
		boolean[] visited = new boolean[v];
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(s);
		visited[s] = true;
		while (!q.isEmpty()) {
			int poppedNode = q.poll();
			result.add(poppedNode);
			List<Integer> childs = adj.get(poppedNode);
			for (int node : childs) {
				if (!visited[node]) {
					q.offer(node);
					visited[node] = true;
				}
			}
		}
		return result;
	}

	// Second Version: No source given and graph may be disconnected.

	public static List<Integer> bfsSecond(List<List<Integer>> adj, int v) {
		List<Integer> result = new ArrayList<>();
		if (adj == null || adj.size() == 0) {
			return result;
		}
		boolean[] visited = new boolean[v];
		for (int i = 0; i < v; i++) {
			if (!visited[i]) {
				List<Integer> res = bfsImpl(adj, visited, i);
				result.addAll(res);
			}
		}
		return result;
	}

	public static List<Integer> bfsImpl(List<List<Integer>> adj, boolean[] visited, int s) {
		List<Integer> result = new ArrayList<>();
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(s);
		visited[s] = true;
		while (!q.isEmpty()) {
			int poppedNode = q.poll();
			result.add(poppedNode);
			List<Integer> childs = adj.get(poppedNode);
			for (int node : childs) {
				if (!visited[node]) {
					q.offer(node);
					visited[node] = true;
				}
			}
		}
		return result;
	}

	// Variation of BFS: Count connected components in an undirected graph.
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
				bfsImpl(adj, visited, i);
				count++;
			}
		}
		return count;
	}

	public static void bfs(List<List<Integer>> adj, boolean[] visited, int s) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(s);
		visited[s] = true;
		while (!q.isEmpty()) {
			int poppedNode = q.poll();
			List<Integer> childs = adj.get(poppedNode);
			for (int node : childs) {
				if (!visited[node]) {
					q.offer(node);
					visited[node] = true;
				}
			}
		}
	}

}
