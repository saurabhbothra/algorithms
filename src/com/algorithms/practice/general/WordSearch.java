package com.algorithms.practice.general;

public class WordSearch {

	// Given an m x n grid of characters board and a string word, return true if
	// word exists in the grid.

	// The word can be constructed from letters of sequentially adjacent cells,
	// where adjacent cells are horizontally or vertically neighboring. The same
	// letter cell may not be used more than once.

	// board and word consists of only lowercase and uppercase English letters.
	// m == board.length
	// n = board[i].length
	// 1 <= m, n <= 6
	// 1 <= word.length <= 15

	// Follow up: Could you use search pruning to make your solution faster with a
	// larger board?

	// Although it is true that we would explore the 2D grid with the DFS strategy
	// for this problem, it does not capture the entire nature of the solution.

	// We argue that a more accurate term to summarize the solution would be
	// backtracking, which is a methodology where we mark the current path of
	// exploration, if the path does not lead to a solution, we then revert the
	// change (i.e. backtracking) and try another path.

	// As the general idea for the solution, we would walk around the 2D grid, at
	// each step we mark our choice before jumping into the next step. And at the
	// end of each step, we would also revert our marking, so that we could have a
	// clean slate to try another direction. In addition, the exploration is done
	// via the DFS strategy, where we go as further as possible before we try the
	// next direction.

	// Time Complexity: Time Complexity: O(N⋅3^L)
	// where N is the number of cells in the board and L is the length of the word
	// to be matched.

	// For the backtracking function, initially we could have at most 4 directions
	// to explore, but further the choices are reduced into 3 (since we won't go
	// back to where we come from because of markings). As a result, the execution
	// trace after the first
	// step could be visualized as a 3-ary tree, each of the branches represent a
	// potential exploration in the corresponding direction. Therefore, in the worst
	// case, the total number of invocation would be the number of nodes in a full
	// 3-nary tree, which is about 3^L.

	// We iterate through the board for backtracking, i.e. there could be NN times
	// invocation for the backtracking function in the worst case.

	// As a result, overall the time complexity of the algorithm would be O(N⋅3^L).

	// Space Complexity: O(L) -> recursion call stacks.

	// dfs solution using backtracking.
	public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					if (dfs(board, word, i, j, 0)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean dfs(char[][] board, String word, int r, int c, int index) {
		if (index == word.length()) {
			return true;
		}
		if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)) {
			return false;
		}
		board[r][c] = '.';
		boolean result = dfs(board, word, r + 1, c, index + 1) || dfs(board, word, r - 1, c, index + 1)
				|| dfs(board, word, r, c + 1, index + 1) || dfs(board, word, r, c - 1, index + 1);
		board[r][c] = word.charAt(index);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordSearch ws = new WordSearch();
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		System.out.println("Does word exist in grid: " + ws.exist(board, "ABCCED"));
	}

}
