package com.leetcode.LongestConsecutiveSequence;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;



public class Solution {
    public int longestConsecutive(int[] num) {
    	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    	for(int i=0;i<num.length;i++)
    		map.put(num[i], 1);
    	int re =1;
    	for(int j=0;j<num.length;j++){
    		if(!map.containsKey(num[j]))
    			continue;
    		map.remove(num[j]);
    		int temp = num[j]+1;
    		int val = 1;
    		while(map.containsKey(temp)){
    			map.remove(temp);
    			val++;
    			temp++;
    		}
    		temp = num[j]-1;
    		while(map.containsKey(temp)){
    			map.remove(temp);
    			temp--;
    			val++;
    		}
    		if(val>re)
    			re=val;
    	}
    	 
		return re;
    	
        
    }

	
}
