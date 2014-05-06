package com.leetcode.ValidSudoku;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Solution {
	public boolean isValidSudoku(char[][] board) {
		
		int row = board.length;
		int col = board[0].length;
		for(int i=0;i<row;i++){
			Map<Character,Character> map = new HashMap<Character,Character>();
			for(int j=0;j<col;j++){
				char temp = board[i][j];
				if(temp!='.'){
					if(map.get(temp)==null){
						map.put(temp, temp);
					}else{
						return false;
					}
				}
			}
		}
		
		for(int i=0;i<row;i++){
			Map<Character,Character> map = new HashMap<Character,Character>();
			for(int j=0;j<col;j++){
				char temp = board[j][i];
				if(temp!='.'){
					if(map.get(temp)==null){
						map.put(temp, temp);
					}else{
						return false;
					}
				}
			}
		}
		return isSmallValid(board, 0, 0) && isSmallValid(board, 3, 0)
				&& isSmallValid(board, 6, 0) && isSmallValid(board, 0, 3)
				&& isSmallValid(board, 3, 3) && isSmallValid(board, 6, 3)
				&& isSmallValid(board, 0, 6) && isSmallValid(board, 3, 6)
				&& isSmallValid(board, 6, 6);
		

		
	}
	
	private boolean isSmallValid(char[][] board, int x, int y) {
		Hashtable<Character, Character> ht = new Hashtable<Character, Character>();
		for (int i = x; i < 3 + x; ++i) {
			for (int j = y; j < 3 + y; ++j) {
				char c = board[i][j];
				if (c == '.') {

				} else {
					if (ht.get(c) == null) {
						ht.put(c, c);
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}
}