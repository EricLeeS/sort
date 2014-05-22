package com.leetcode.LargestRectangleinHistogram;

public class Solution {
    public int largestRectangleArea(int[] height) {
    	if(height.length==0)
    		return 0;
    	if(height.length==1)
    		return height[0];
    	int re=0;
    	for(int i=0;i<height.length;i++){
    		int min = height[i];
    		for(int j=i;j>=0;j--){
    			min=Math.min(height[j],min);
    			re=Math.max(min*(i-j+1), re);
    		}
    	}
		return re;
        
    }
}
