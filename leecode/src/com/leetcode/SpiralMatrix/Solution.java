package com.leetcode.SpiralMatrix;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
    	ArrayList<Integer> re = new ArrayList<Integer>();
    	
    	if(matrix.length==0)
    		return re;
    	
    	
    	int row = matrix.length;
    	int col = matrix[0].length;
    	
    	int start=-1;
    	int end=-1;
    	int temprow=row;
    	int tempcol = col;
    	
    	while(temprow>0&&tempcol>0){
    		start++;
    		end++;
    		//如果剩下的行数或者列数位0
    		if(temprow==start||tempcol==end)
    			break;
    		for(int i=start;i<tempcol;i++)
    			re.add(matrix[start][i]);
    		for(int j=start+1;j<temprow;j++)
    			re.add(matrix[j][tempcol-1]);
    		
    		//如果剩余一行或者一列
    		if((temprow-1)==start||(tempcol-1)==end)
    			break;
    		for(int x=tempcol-2;x>=end;x--)
    			re.add(matrix[temprow-1][x]);
    		for(int y=temprow-2;y>start;y--)
    			re.add(matrix[y][end]);
    		
    		temprow=temprow-1;
    		tempcol=tempcol-1;
    	}
		return re;
        
    }
}
