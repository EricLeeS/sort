package com.leetcode.Triangle;

import java.util.ArrayList;

public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
    	if(triangle.size()==0)
    		return 0;
    	int len = triangle.size();
    	int[] re = new int[len];
    	re[0]=triangle.get(0).get(0);
    	int min=re[0];
    	for(int i=1;i<triangle.size();i++){
    		ArrayList<Integer> al = triangle.get(i);
    		int pre = 0;
    		
    		for(int j=0;j<al.size();j++){
    			if(j==0){
    				pre=re[0];
    				re[0]+=al.get(j);
    				min=re[0];
    				continue;
    			}
    			if(j==al.size()-1){
    				re[j]=pre+al.get(j);
    				if(re[j]<min)
    					min=re[j];
    				continue;
    			}
    			int temp = re[j];
    			re[j]=Math.min(pre, re[j])+al.get(j);
    			pre = temp;
    			if(re[j]<min)
    				min=re[j];
    		}
    		
    	}
		return min;
        
    }
}