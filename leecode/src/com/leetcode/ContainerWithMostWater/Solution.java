package com.leetcode.ContainerWithMostWater;

public class Solution {  
    public int maxArea(int[] height) {
    	if(height.length<2)
    		return 0;
    	int re=0;
    	int j=height.length-1;
    	int i=0;
    	while(j>i){
    		if(height[i]>=height[j]){
    			int area = height[j]*(j-i);
    			if(area>re)
    				re=area;
    			j--;
    			continue;
    		}else{
    			int area=height[i]*(j-i);
    			if(area>re)
    				re=area;
    			i++;
    			continue;
    		}
    	}
		return re;  
         
  
    }  
}  