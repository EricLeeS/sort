package com.leetcode.MinimumPathSum;

public class Solution {
    public int minPathSum(int[][] grid) {
    	int row = grid.length;
    	int col = grid[0].length;
    	int[] re = new int[col];
    	re[0]=grid[0][0];
    	for(int i=1;i<col;i++){
    		re[i]=grid[0][i]+re[i-1];
    	}
    	for(int m=1;m<row;m++){
    		for(int n=0;n<col;n++){
    			if(n==0){
    				re[n]+=grid[m][n];
    			}else{
    				if(re[n-1]>re[n]){
    					re[n]+=grid[m][n];
    				}else{
    					re[n]=re[n-1]+grid[m][n];
    				}
    				
    			}
    			
    		}
    	}
		return re[col-1];
        
    }
}