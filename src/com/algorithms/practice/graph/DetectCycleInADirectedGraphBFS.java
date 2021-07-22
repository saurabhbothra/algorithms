package com.algorithms.practice.graph;

import java.util.ArrayDeque;
import java.util.List;

public class DetectCycleInADirectedGraphBFS {

	// Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges,
	// check whether it contains any cycle or not.

	// bfs based solution, using kahn's algorithm.
	public static boolean isCyclicBfs(List<List<Integer>> adj, int V) {
		if (adj == null || adj.size() == 0) {
			return false;
		}
		int[] inDegree = new int[V];
		for (List<Integer> edges : adj) {
			for (Integer node : edges) {
				inDegree[node] = inDegree[node] + 1;
			}
		}
		int count = 0;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < V; i++) {
			if (inDegree[i] == 0) {
				q.offer(i);
			}
		}
		while (!q.isEmpty()) {
			Integer poppedNode = q.poll();
			List<Integer> childs = adj.get(poppedNode);
			for (Integer node : childs) {
				inDegree[node] = inDegree[node] - 1;
				if (inDegree[node] == 0) {
					q.offer(node);
				}
			}
			count++;
		}
		return count != V;
	}

}
