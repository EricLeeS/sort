package com.leetcode.uniquePathII;

public class Main {
	public static void main(String[] args){
		Solution so = new Solution();
		int[][] num = {{0,1,0,0,0},{1,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
		System.out.println(so.uniquePathsWithObstacles(num));
	}
}
