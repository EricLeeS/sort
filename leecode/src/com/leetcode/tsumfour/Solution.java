package com.leetcode.tsumfour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
    	ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
    	Map<ArrayList<Integer>,Integer> map = new HashMap<ArrayList<Integer>,Integer>();
    	ArrayList<Integer> ai = new ArrayList<Integer>();
    	if(num.length<=3)
    		return re;
    	Arrays.sort(num);
    	for(int i=0;i<num.length-3;i++){
    		
    		ai = new ArrayList<Integer>();
    		ai.add(num[i]);
    		int tar = target-num[i];
    		for(int j=i+1;j<num.length-2;j++){
    			int temp = num[j];
    			ai = new ArrayList<Integer>();
    			ai.add(num[i]);
    			ai.add(temp);
    			int tt = tar-temp;
    			int start = j+1;
    			int end = num.length-1;
    			while(end>start){
        			if(num[start]+num[end]==tt){
        				ai.add(num[start]);
        				ai.add(num[end]);
        				map.put(ai, 1);
        				ai=new ArrayList<Integer>();
        				ai.add(num[i]);
        				ai.add(temp);
        				start++;
        				end--;
        				continue;
        			}
        			if(num[start]+num[end]>tt){
        				end--;
        				continue;
        			}
        			if(num[start]+num[end]<tt){
        				start++;
        				continue;
        			}
        		}
    		}
    		
    	}
    	re.addAll(map.keySet());
		return re;
        
    }
}
