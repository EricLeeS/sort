package com.leetcode.SurroundedRegions;

public class Main {
	public static void main(String[] args){
		char[][] board = {{'O','X','X','O','X'},
						  {'X','O','O','X','O'},
						  {'X','O','X','O','X'},
						  {'O','X','O','O','O'},
						  {'X','X','O','X','O'}};
		Solution so = new Solution();
		so.solve(board);
	}
}
