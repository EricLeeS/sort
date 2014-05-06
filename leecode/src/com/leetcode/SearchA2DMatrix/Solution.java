package com.leetcode.SearchA2DMatrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
		int row=matrix.length;
		int col=matrix[0].length;
    	if(row==0||col==0||matrix[0][0]>target||matrix[row-1][col-1]<target){
    		return false;
    	}
    	int in =-1;
    	for(int i=1;i<row;i++){
    		if(matrix[i][0]>target){
    			in = i-1;
    			break;
    		}
    	}
    	if(in==-1){
    		in = row-1;
    	}
    	
    	for(int x=0;x<col;x++){
    		if(matrix[in][x]==target){
    			return true;
    		}
    	}
    	
    	return false;
        
    }
}
