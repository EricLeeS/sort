package com.leetcode.CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NSolution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
    	Map<ArrayList<Integer>,Integer> remap = new HashMap<ArrayList<Integer>,Integer>();
    	ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
    	if(num.length==0)
    		return re;
    	Map<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
    	ArrayList<Integer> ai = new ArrayList<Integer>();
    	Arrays.sort(num);
    	
    	for(int m=0;m<num.length;m++){
    		for(int i=m;i<num.length;i++){
        		ai=new ArrayList<Integer>();
        		ai.add(num[i]);
        		if(num[i]==target){
        			remap.put(ai, 1);
        			map.put(i, null);
        		}else{
        			map.put(i, ai);
        		}    		
        	}
    		for(int j=m;j<num.length;j++){
        		for(int k=j+1;k<num.length;k++){
        			if(map.get(k)!=null){
        				map.get(k).add(0, num[j]);
            			int sum = Sum(map.get(k));
            			if(sum==target){
            				remap.put(map.get(k), 1);
            				map.put(k, null);
            				continue;
            			}
            			if(sum>target){
            				map.put(k, null);
            			}
        			}
        			
        		}
        	}
    	}
    	
    	re.addAll(remap.keySet());
		return re;
        
    }

	private int Sum(ArrayList<Integer> al) {
		// TODO Auto-generated method stub
		int re=0;
		for(int i=0;i<al.size();i++){
			re+=al.get(i);
		}
		return re;
	}
}
