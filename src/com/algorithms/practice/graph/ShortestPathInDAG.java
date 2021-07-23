package com.algorithms.practice.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestPathInDAG {

	// Given a DAG, and a source vertex, we need to find out the shortest distance
	// from source vertex to every other vertex. Each edge has weights assigned to
	// it.

	// bfs based approach using topological sorting.
	public static int[] findShortestPath(List<List<List<Integer>>> adj, int V, int source) {
		if (adj == null || adj.size() == 0) {
			return null;
		}
		int[] distances = new int[V];
		for (int i = 0; i < V; i++) {
			if (i != source) {
				distances[i] = Integer.MAX_VALUE;
			}
		}
		int[] inDegree = new int[V];
		for (List<List<Integer>> edges : adj) {
			for (List<Integer> edge : edges) {
				int node = edge.get(0);
				inDegree[node] = inDegree[node] + 1;
			}
		}
		ArrayDeque<Integer> q = new ArrayDeque<>();
		boolean isFlag = false;
		for (int i = 0; i < V; i++) {
			if (inDegree[i] == 0) {
				q.offer(i);
			}
		}
		while (!q.isEmpty()) {
			Integer poppedNode = q.poll();
			List<List<Integer>> childs = adj.get(poppedNode);
			if (poppedNode == source) {
				isFlag = true;
			}
			for (List<Integer> nodeDetails : childs) {
				int node = nodeDetails.get(0);
				int weight = nodeDetails.get(1);
				inDegree[node] = inDegree[node] - 1;
				if (inDegree[node] == 0) {
					q.offer(node);
				}
				if (isFlag) {
					if (distances[poppedNode] != Integer.MAX_VALUE) {
						distances[node] = Math.min(distances[node], distances[poppedNode] + weight);
					}
				}
			}
		}
		return distances;
	}

	// dfs based approach using topological sorting.
	public static int[] findShortestPathDFS(List<List<List<Integer>>> adj, int V, int source) {
		if (adj == null || adj.size() == 0) {
			return new int[] {};
		}
		int[] result = new int[V];
		boolean[] visited = new boolean[V];
		int[] distances = new int[V];
		for (int i = 0; i < V; i++) {
			if (i != source) {
				distances[i] = Integer.MAX_VALUE;
			}
		}
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
		for (int i = 0; i < V; i++) {
			List<List<Integer>> childs = adj.get(i);
			for (List<Integer> nodeDetails : childs) {
				Integer node = nodeDetails.get(0);
				Integer weight = nodeDetails.get(1);
				if (distances[i] != Integer.MAX_VALUE) {
					distances[node] = Math.min(distances[node], distances[i] + weight);
				}
			}
		}
		return distances;
	}

	// helper method to do dfs using recursion.
	public static void dfsRec(List<List<List<Integer>>> adj, ArrayDeque<Integer> st, int source, boolean[] visited) {
		visited[source] = true;
		List<List<Integer>> childs = adj.get(source);
		for (List<Integer> nodeList : childs) {
			Integer node = nodeList.get(0);
			if (!visited[node]) {
				dfsRec(adj, st, node, visited);
			}
		}
		st.push(source);
	}

	public static void main(String[] args) {
		List<List<List<Integer>>> adj = new ArrayList<>();
		int V = 6;
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}

		List<List<Integer>> edgeList = adj.get(0);
		for (int i = 0; i < 2; i++) {
			edgeList.add(new ArrayList<>());
		}
		List<Integer> e1 = edgeList.get(0);
		e1.add(1);
		e1.add(2);
		List<Integer> e2 = edgeList.get(1);
		e2.add(4);
		e2.add(1);

		List<List<Integer>> edgeList1 = adj.get(1);
		edgeList1.add(new ArrayList<>());
		List<Integer> e3 = edgeList1.get(0);
		e3.add(2);
		e3.add(3);

		List<List<Integer>> edgeList2 = adj.get(2);
		edgeList2.add(new ArrayList<>());
		List<Integer> e4 = edgeList2.get(0);
		e4.add(3);
		e4.add(6);

		List<List<Integer>> edgeList4 = adj.get(4);
		edgeList4.add(new ArrayList<>());
		List<Integer> e5 = edgeList4.get(0);
		e5.add(2);
		e5.add(2);
		edgeList4.add(new ArrayList<>());
		List<Integer> e6 = edgeList4.get(1);
		e6.add(5);
		e6.add(4);

		List<List<Integer>> edgeList5 = adj.get(5);
		edgeList5.add(new ArrayList<>());
		List<Integer> e7 = edgeList5.get(0);
		e7.add(3);
		e7.add(1);

		System.out.println(Arrays.toString(findShortestPath(adj, V, 0)));
		System.out.println(Arrays.toString(findShortestPathDFS(adj, V, 0)));
	}

}
