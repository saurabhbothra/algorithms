package com.algorithms.practice.graph;

import java.util.ArrayDeque;
import java.util.List;

public class KahnTopologicalBFSAlgorithm {

	// Given a directed acyclic graph (no cycles), we need to find topological
	// sorting of it. You can find any topological sort of the graph.

	// kahn's algorithm, bfs based.
	public int[] topologicalSort(List<List<Integer>> adj, int V) {
		if (adj == null || adj.size() == 0) {
			return new int[] {};
		}
		int[] result = new int[V];
		int[] inDegree = new int[V];
		for (List<Integer> edges : adj) {
			for (Integer node : edges) {
				inDegree[node] = inDegree[node] + 1;
			}
		}
		int index = 0;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < V; i++) {
			if (inDegree[i] == 0) {
				q.offer(i);
			}
		}
		while (!q.isEmpty()) {
			Integer poppedNode = q.poll();
			List<Integer> childs = adj.get(poppedNode);
			result[index] = poppedNode;
			index++;
			for (Integer node : childs) {
				inDegree[node] = inDegree[node] - 1;
				if (inDegree[node] == 0) {
					q.offer(node);
				}
			}
		}
		return result;
	}

}
