package com.leetcode.Combinations;

import java.util.ArrayList;
import java.util.Iterator;

public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
    	if(k>n)
    		return null;
    	ArrayList<Integer> ai = new ArrayList<Integer>();
    	ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
    	for(int m=0;m<n;m++){
    		ai=new ArrayList<Integer>();
    		ai.add(m+1);
    		re.add(ai);
    	}
    	for(int i=1;i<k;i++){
    		Iterator<ArrayList<Integer>> it = re.iterator();
    		ArrayList<ArrayList<Integer>> tempre = new ArrayList<ArrayList<Integer>>();
    		while(it.hasNext()){
    			ArrayList<Integer> temp = it.next();
    			int tt = temp.get(temp.size()-1);
    			for(int j=tt+1;j<=n;j++){
    				ArrayList<Integer> newtemp = new ArrayList<Integer>();
    				newtemp.addAll(temp);
    				
    				newtemp.add(j);
    				tempre.add(newtemp);
    			}
    		}
    		re=tempre;
    	}
		return re;
        
    }
}
