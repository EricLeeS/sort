package com.leetcode.SudokuSolver;

import java.util.ArrayList;

public class Solution {
	public void solveSudoku(char[][] board) {
		ArrayList<Integer> empty = new ArrayList<Integer>();
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				if (board[i][j] == '.') {
					empty.add(i * 9 + j);
				}
		int len = empty.size();
		dfs(empty, board, 0, len);
	}

	private boolean dfs(ArrayList<Integer> empty, char[][] board, int cur, int len) {
		if(cur==len){
			return true;
		}
		int row = cur/9;
		int col = cur%9;
		for(int i=1;i<10;i++){
			if(isValid(i,row,col,board)){
				board[row][col]=(char)(i+'0');
				if(dfs(empty,board,cur+1,len)){
					return true;
				}
				board[row][col]='.';
				
				
			}
		}
		
		
		return false;
		
		
	}

	 public boolean isValid(int v, int row, int col, char[][] board){
	        for(int i=0;i<9;i++){
	            if(board[row][i] - '0'==v) return false;
	            if(board[i][col] - '0'==v) return false;
	            //验证小九宫格
	            int row_s = 3*(row/3) + i/3;
	            int col_s = 3*(col/3) + i%3;
	            if(board[row_s][col_s] - '0'==v) return false;
	        }
	        return true;
	    }
}
