package com.algorithms.practice.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class KosarajuAlgorithm {

	// Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges,
	// Find the number of strongly connected components in the graph.

	// efficient implementation of kosaraju algorithm.
	public static int findStronglyConnectedComponents(List<List<Integer>> adj, int V) {
		boolean[] visited = new boolean[V];
		ArrayDeque<Integer> st = new ArrayDeque<>();
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				topoSort(adj, visited, st, i);
			}
		}
		List<List<Integer>> transposeGraph = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			visited[i] = false;
			transposeGraph.add(new ArrayList<>());
		}
		createTranspose(V, adj, transposeGraph);
		int count = 0;
		while (!st.isEmpty()) {
			int source = st.pop();
			if (!visited[source]) {
				count++;
				dfsTransposeGraph(transposeGraph, visited, source);
			}
		}
		return count;
	}

	// helper method to do dfs of transpose graph.
	public static void dfsTransposeGraph(List<List<Integer>> transposeGraph, boolean[] visited, int source) {
		visited[source] = true;
		List<Integer> childs = transposeGraph.get(source);
		for (Integer node : childs) {
			if (!visited[node]) {
				dfsTransposeGraph(transposeGraph, visited, node);
			}
		}
	}

	// helper method to create transpose of original graph.
	public static void createTranspose(int V, List<List<Integer>> adj, List<List<Integer>> transposeGraph) {
		for (int i = 0; i < V; i++) {
			List<Integer> childs = adj.get(i);
			for (Integer node : childs) {
				transposeGraph.get(node).add(i);
			}
		}
	}

	// helper method to find deceasing order of finish times.
	public static void topoSort(List<List<Integer>> adj, boolean[] visited, ArrayDeque<Integer> st, int source) {
		visited[source] = true;
		List<Integer> childs = adj.get(source);
		for (Integer node : childs) {
			if (!visited[node]) {
				topoSort(adj, visited, st, node);
			}
		}
		st.push(source);
	}

}
