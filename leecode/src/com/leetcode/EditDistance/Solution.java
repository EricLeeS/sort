package com.leetcode.EditDistance;

public class Solution {
    public int minDistance(String word1, String word2) {
    	int row = word1.length()+1;
    	int col = word2.length()+1;
    	int[][] dp = new int[row][col];
    	for(int i=0;i<row;i++)
    		dp[i][0]=i;
    	for(int j=0;j<col;j++)
    		dp[0][j]=j;
    	for(int x=1;x<row;x++){
    		char cx = word1.charAt(x-1);
    		for(int y=1;y<col;y++){
    			char cy=word2.charAt(y-1);
    			if(cx==cy)
    				dp[x][y]=dp[x-1][y-1];
    			else{
    				 int dEdit = dp[x-1][y-1] + 1;
    				 int dAdd = dp[x][y-1] + 1;
    				 int dDel = dp[x-1][y] + 1;
    				 dp[x][y]=Math.min(dDel,Math.min(dAdd, dEdit));
    			}
    		}
    	}
		return dp[row-1][col-1];
        
    }
}
