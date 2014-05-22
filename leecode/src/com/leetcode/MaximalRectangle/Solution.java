package com.leetcode.MaximalRectangle;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
    	int row = matrix.length;
    	if(row==0)
    		return 0;
    	int col = matrix[0].length;
    	if(col==0)
    		return 0;
    	
    	int[][] addCol=new int[row][col];
    	
    	for(int n=0;n<col;n++)
    		addCol[0][n]=matrix[0][n]-'0';
    	
    	
    	for(int x=0;x<col;x++){
    		for(int y=1;y<row;y++){
    			if(matrix[y][x]=='0')
    				addCol[y][x]=0;
    			else
    				addCol[y][x]=addCol[y-1][x]+1;
    		}
    	}
    	int re = 0;
    	for(int a=row-1;a>=0;a--){
    		int maxCon = largestRectangleArea(addCol[a]);
    		
    			if(maxCon>re)
    				re=maxCon;
    		
    	}
    	
		return re;
        
    }
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        int[] h = new int[height.length + 1];
        h = Arrays.copyOf(height, height.length + 1);
        while(i < h.length){
            if(stack.isEmpty() || h[stack.peek()] <= h[i]){
                stack.push(i++);
            }else {
                int t = stack.pop();
                maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return maxArea;
    }
//    public int largestRectangleArea(int[] height) {
//    	if(height.length==0)
//    		return 0;
//    	if(height.length==1)
//    		return height[0];
//    	int re=0;
//    	for(int i=0;i<height.length;i++){
//    		int min = height[i];
//    		for(int j=i;j>=0;j--){
//    			min=Math.min(height[j],min);
//    			re=Math.max(min*(i-j+1), re);
//    		}
//    	}
//		return re;
//        
//    }
	

	
}