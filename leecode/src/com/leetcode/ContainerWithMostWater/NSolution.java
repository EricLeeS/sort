package com.leetcode.ContainerWithMostWater;

public class NSolution {
    public int maxArea(int[] height) {
    	if(height.length<2)
    		return 0;
    	int re=0;
    	for(int i=1;i<height.length;i++){
    		for(int j=0;j<i;j++){
    			int temp=0;
    			if(height[i]>=height[j])
    				temp=height[j];
    			else
    				temp=height[i];
    			int area=temp*(i-j);
    			if(area>re)
    				re=area;
    			
    		}
    	}
		return re;
        
    }
}
