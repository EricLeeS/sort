package com.leetcode.GasStation;

import java.util.ArrayList;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	if(gas.length!=cost.length)
    		return -1;
    	int[] re=new int[gas.length];
    	ArrayList<Integer> ar = new ArrayList<Integer>();
    	int tt=0;
    	for(int i=0;i<gas.length;i++){    		
    		re[i]=gas[i]-cost[i];
    		tt+=re[i];
    		if(re[i]>=0)
    			ar.add(i);
    	}
    	if(tt<0)
    		return -1;
    	int len = gas.length;
    	while(!ar.isEmpty()){
    		int tindex = ar.get(0);
    		ar.remove(Integer.valueOf(tindex));
    		int t = (tindex+1)%len;
    		int sum=re[tindex];
    		while(t!=tindex){
    			sum+=re[t];
    			if(sum<0){
    				break;
    			}else{
    				if(re[t]>=0)
    					ar.remove(Integer.valueOf(t));
    				t++;
    				t=t%len;
    			}
    				
    		}
    		if(sum>=0)
    			return tindex;
    	}
		return -1;
        
    }
}
