package com.leetcode.RotateImage;

public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        for(int i=1;i<n;i++){
        	for(int j=0;j<i;j++){
        		int temp = matrix[i][j];
        		matrix[i][j]=matrix[j][i];
        		matrix[j][i]=temp;
        	}
        }
        
        for(int m=0;m<n/2;m++){
        	for(int mm=0;mm<n;mm++){
        		int temp = matrix[mm][m];
        		matrix[mm][m]=matrix[mm][n-m-1];
        		matrix[mm][n-m-1]=temp;
        	}
        }
        
    }
}
