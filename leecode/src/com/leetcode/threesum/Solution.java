package com.leetcode.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
    	ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>(); 
    	Map<ArrayList<Integer>,Integer> map = new HashMap<ArrayList<Integer>,Integer>();
    	ArrayList<Integer> ai = new ArrayList<Integer>();
    	if(num.length<=2)
    		return re;
    	Arrays.sort(num);
    	for(int i=0;i<num.length-2;i++){
    		int temp = num[i];
    		ai = new ArrayList<Integer>();
    		ai.add(temp);
    		int start = i+1;
    		int end=num.length-1;
    		int target = -temp;
    		while(end>start){
    			if(num[start]+num[end]==target){
    				ai.add(num[start]);
    				ai.add(num[end]);
    				map.put(ai, 1);
    				ai=new ArrayList<Integer>();
    				ai.add(temp);
    				start++;
    				end--;
    				continue;
    			}
    			if(num[start]+num[end]>target){
    				end--;
    				continue;
    			}
    			if(num[start]+num[end]<target){
    				start++;
    				continue;
    			}
    		}
    	}
    	re.addAll(map.keySet());
		return re;
        
    }
}