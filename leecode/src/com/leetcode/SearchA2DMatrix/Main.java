package com.leetcode.SearchA2DMatrix;

public class Main {
	public static void main(String[] args){
		int[][] matrix={{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
		Solution so = new Solution();
		System.out.println(so.searchMatrix(matrix, 12));
	}
}
