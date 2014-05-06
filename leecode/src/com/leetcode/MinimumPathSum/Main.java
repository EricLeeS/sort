package com.leetcode.MinimumPathSum;

public class Main {
	public static void main(String[] args){
		int[][] grid ={{1,3,1},{1,5,1},{4,2,1}};
		Solution so = new Solution();
		int temp =so.minPathSum(grid);
		System.out.println(temp);
	}
}
