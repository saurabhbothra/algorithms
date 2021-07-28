package com.algorithms.practice.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFordShortestPathAlgorithm {

	// Given a directed graph with positive or negative weight edges and a source
	// vertex, we need to find shortest path of each vertex from source vertex.

	// efficient implementation of bellman ford algorithm.
	public static int[] bellmanFord(List<List<List<Integer>>> adj, int source, int V) {
		int[] distances = new int[V];
		for (int i = 0; i < V; i++) {
			if (i == source) {
				distances[i] = 0;
			} else {
				distances[i] = Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < V - 1; i++) {
			for (int j = 0; j < V; j++) {
				List<List<Integer>> childs = adj.get(j);
				for (List<Integer> nodeDetails : childs) {
					int node = nodeDetails.get(0);
					int weight = nodeDetails.get(1);
					if (distances[j] == Integer.MAX_VALUE) {
						continue;
					}
					if (distances[node] > distances[j] + weight) {
						distances[node] = distances[j] + weight;
					}
				}
			}
		}
		return distances;
	}

	public static void main(String[] args) {
		List<List<List<Integer>>> adj = new ArrayList<>();
		int V = 4;
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}

		List<List<Integer>> edgeList = adj.get(0);
		for (int i = 0; i < 2; i++) {
			edgeList.add(new ArrayList<>());
		}
		List<Integer> e1 = edgeList.get(0);
		e1.add(1);
		e1.add(1);
		List<Integer> e2 = edgeList.get(1);
		e2.add(2);
		e2.add(4);

		List<List<Integer>> edgeList1 = adj.get(1);
		for (int i = 0; i < 2; i++) {
			edgeList1.add(new ArrayList<>());
		}
		List<Integer> e3 = edgeList1.get(0);
		e3.add(2);
		e3.add(-3);
		List<Integer> e4 = edgeList1.get(1);
		e4.add(3);
		e4.add(2);

		List<List<Integer>> edgeList2 = adj.get(2);
		edgeList2.add(new ArrayList<>());
		List<Integer> e5 = edgeList2.get(0);
		e5.add(3);
		e5.add(3);

		System.out.println(Arrays.toString(bellmanFord(adj, 0, V)));
	}

}
