package com.leetcode.WordSearch;

public class Main {
	public static void main(String[] args){
		String sr = "AAB";
		char[][] board={{'C','A','A'},{'A','A','D'},{'B','C','D'}};
		Solution so = new Solution();
		System.out.println(so.exist(board, sr));
	}
}
