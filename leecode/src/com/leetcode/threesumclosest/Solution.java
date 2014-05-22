package com.leetcode.threesumclosest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int threeSumClosest(int[] num, int target) {
    	if(num.length<=2)
    		return 0;
    	Arrays.sort(num);
    	int re=0;
    	int min = Integer.MAX_VALUE;
    	for(int i=0;i<num.length-2;i++){
    		int temp = num[i];
    		int start = i+1;
    		int end=num.length-1;
    		while(end>start){
    			int sr = num[start]+num[end]+temp;
    			if(sr==target)
    				return target;
    			if(sr>target){
    				if(Math.abs(sr-target)<min){
    					min=Math.abs(sr-target);
    					re=sr;
    				}
    					
    				end--;
    				continue;
    			}
    			if(sr<target){
    				if(Math.abs(sr-target)<min){
    					min=Math.abs(sr-target);
    					re=sr;
    				}
    					
    				start++;
    				continue;
    			}
    		}
    	}
		return re;
        
    }
}
