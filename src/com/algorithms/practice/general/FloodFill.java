package com.algorithms.practice.general;

public class FloodFill {
	
	// An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

	// You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the pixel image[sr][sc].

	// To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.

	// Return the modified image after performing the flood fill.
	
	private int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    
    
    private void dfs(int[][] grid, int r, int c, int newColor, int val) { 
        grid[r][c] = newColor;
        for(int i = 0; i < directions.length; i++) {
            int nr = r + directions[i][0];
            int nc = c + directions[i][1];
            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == val) {
                dfs(grid, nr, nc, newColor, val);
            }
        }
    }
    
    // dfs solution.
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor) {
            return image;
        }
        dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }



}
