package com.algorithms.practice.general;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PacificAtlanticWaterFlow {

	// There is an m x n rectangular island that borders both the Pacific Ocean and
	// Atlantic Ocean. The Pacific Ocean touches the island's left and top edges,
	// and the Atlantic Ocean touches the island's right and bottom edges.

	// The island is partitioned into a grid of square cells. You are given an m x n
	// integer matrix heights where heights[r][c] represents the height above sea
	// level of the cell at coordinate (r, c).

	// The island receives a lot of rain, and the rain water can flow to neighboring
	// cells directly north, south, east, and west if the neighboring cell's height
	// is less than or equal to the current cell's height. Water can flow from any
	// cell adjacent to an ocean into the ocean.

	// Return a 2D list of grid coordinates result where result[i] = [ri, ci]
	// denotes that rain water can flow from cell (ri, ci) to both the Pacific and
	// Atlantic oceans.

	private boolean isPacific = false;
	private boolean isAtlantic = false;
	private static int[][] directions = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

	// dfs solution.
	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		List<List<Integer>> result = new ArrayList<>();
		int[][] visited = new int[heights.length][heights[0].length];
		for (int i = 0; i < heights.length; i++) {
			for (int j = 0; j < heights[i].length; j++) {
				dfs(heights, i, j, visited);
				if (isPacific && isAtlantic) {
					visited[i][j] = -1;
					result.add(Arrays.asList(i, j));
				}
				isPacific = false;
				isAtlantic = false;
			}
		}
		return result;
	}

	private void dfs(int[][] heights, int row, int col, int[][] visited) {
		if (visited[row][col] == -1) {
			isPacific = true;
			isAtlantic = true;
			return;
		}
		if (row == 0 || col == 0) {
			isPacific = true;
		}
		if (row == heights.length - 1 || col == heights[0].length - 1) {
			isAtlantic = true;
		}
		if (isPacific && isAtlantic) {
			return;
		}
		int temp = heights[row][col];
		heights[row][col] = -2;
		for (int i = 0; i < directions.length; i++) {
			int newRow = row + directions[i][0];
			int newCol = col + directions[i][1];
			if (newRow >= 0 && newRow < heights.length && newCol >= 0 && newCol < heights[0].length
					&& heights[newRow][newCol] != -2 && heights[newRow][newCol] <= temp) {
				dfs(heights, newRow, newCol, visited);
			}
		}
		heights[row][col] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PacificAtlanticWaterFlow pa = new PacificAtlanticWaterFlow();
		int[][] heights = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 },
				{ 5, 1, 1, 2, 4 } };
		List<List<Integer>> cells = pa.pacificAtlantic(heights);
		System.out.println("The paths are:");
		for (List<Integer> cell : cells) {
			System.out.println(cell.get(0) + " " + cell.get(1));
		}
	}

}
