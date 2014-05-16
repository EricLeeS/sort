package com.leetcode.SpiralMatrixII;

public class Solution {
    public int[][] generateMatrix(int n) {
    	int[][] matrix=new int[n][n];
    	int temprow=n;
    	int tempcol=n;
    	int start =-1;
    	int end=-1;
    	int t=1;
    	while(temprow>0&&tempcol>0){
    		start++;
    		end++;
    		for(int i=start;i<tempcol;i++){
    			matrix[start][i]=t;
    			t++;
    		}
    			
    		for(int j=start+1;j<temprow;j++){
    			matrix[j][tempcol-1]=t;
    			t++;
    		}
    		for(int x=tempcol-2;x>=end;x--){
    			matrix[temprow-1][x]=t;
    			t++;
    		}
    			
    		for(int y=temprow-2;y>start;y--){
    			matrix[y][end]=t;
    			t++;
    		}
    			
    		
    		temprow=temprow-1;
    		tempcol=tempcol-1;
    	}
		return matrix;
        
    }
}
