package com.algorithms.practice.graph;

import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

	// Given a weighted, undirected and connected graph of V vertices and E edges,
	// Find the shortest distance of all the vertex's from the source vertex S.

	// Note: The Graph doesn't contain any negative weight cycle.

	// naive implementation of dijkstras algorithm using adjacency matrix.
	public static int[] dijkstraShortestPathNaiveMatrix(int[][] graph, int V, int S) {
		int[] distances = new int[V];
		for (int i = 0; i < V; i++) {
			if (i == S) {
				distances[i] = 0;
			} else {
				distances[i] = Integer.MAX_VALUE;
			}
		}
		boolean[] visited = new boolean[V];
		for (int count = 0; count < V; count++) {
			int u = -1;
			for (int i = 0; i < V; i++) {
				if (!visited[i] && (u == -1 || distances[u] > distances[i])) {
					u = i;
				}
			}
			visited[u] = true;
			for (int i = 0; i < V; i++) {
				if (!visited[i] && graph[u][i] != 0 && distances[i] > (distances[u] + graph[u][i])) {
					distances[i] = distances[u] + graph[u][i];
				}
			}
		}
		return distances;
	}

	// naive implementation of dijkstras algorithm using adjacency list.
	public static int[] dijkstraShortestPathNaive(List<List<List<Integer>>> adj, int V, int S) {
		int[] distances = new int[V];
		for (int i = 0; i < V; i++) {
			if (i == S) {
				distances[i] = 0;
			} else {
				distances[i] = Integer.MAX_VALUE;
			}
		}
		boolean[] visited = new boolean[V];
		for (int count = 0; count < V; count++) {
			int u = -1;
			for (int i = 0; i < V; i++) {
				if (!visited[i] && (u == -1 || distances[u] > distances[i])) {
					u = i;
				}
			}
			visited[u] = true;
			List<List<Integer>> childs = adj.get(u);
			for (List<Integer> nodeDetails : childs) {
				int node = nodeDetails.get(0);
				int weight = nodeDetails.get(1);
				if (!visited[node] && distances[node] > (distances[u] + weight)) {
					distances[node] = distances[u] + weight;
				}
			}
		}
		return distances;
	}

	// efficient implementation of dijkstras algorithm using min heap.
	public static int[] dijkstraShortestPath(List<List<List<Integer>>> adj, int V, int S) {
		PriorityQueue<DNode> key = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.weight, n2.weight));
		int[] distances = new int[V];
		key.add(new DNode(S, 0));
		boolean[] visited = new boolean[V];
		while (!key.isEmpty()) {
			DNode poppedNode = key.poll();
			int u = poppedNode.data;
			if (visited[u]) {
				continue;
			}
			visited[u] = true;
			distances[u] = poppedNode.weight;
			List<List<Integer>> childs = adj.get(u);
			for (List<Integer> nodeDetails : childs) {
				int node = nodeDetails.get(0);
				int weight = nodeDetails.get(1);
				if (!visited[node])
					key.add(new DNode(node, distances[u] + weight));
			}
		}
		return distances;
	}

}

class DNode {
	int data;
	int weight;

	DNode(int data, int weight) {
		this.data = data;
		this.weight = weight;
	}
}
