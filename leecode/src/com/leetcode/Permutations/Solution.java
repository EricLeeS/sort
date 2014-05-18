package com.leetcode.Permutations;

import java.util.ArrayList;
import java.util.Iterator;

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
    	ArrayList<ArrayList<Integer>> re =new ArrayList<ArrayList<Integer>>();
    	if(num.length==0)
    		return re;
    	ArrayList<Integer> ai = new ArrayList<Integer>();
    	ArrayList<ArrayList<Integer>> te =new ArrayList<ArrayList<Integer>>();
    	ai.add(num[0]);
    	re.add(ai);
    	te.add(ai);
    	if(num.length==1)
    		return re;
    	for(int i=1;i<num.length;i++){
    		int t = num[i];
    		Iterator<ArrayList<Integer>> it = re.iterator();
    		te =new ArrayList<ArrayList<Integer>>();
    		while(it.hasNext()){
    			ai = it.next();
    			for(int j=0;j<ai.size();j++){
    				ai.add(j, t);
    				ArrayList<Integer> tem = new ArrayList<Integer>();
    				for(int mm=0;mm<ai.size();mm++)
    					tem.add(ai.get(mm));
    				te.add(tem);
    				ai.remove(j);
    			}
    			ArrayList<Integer> ttem = new ArrayList<Integer>();
    			for(int nn=0;nn<ai.size();nn++)
    				ttem.add(ai.get(nn));
    			ttem.add(t);
    			te.add(ttem);
    			
    		}
    		re=te;
			te=new ArrayList<ArrayList<Integer>>();
    	}
		return re;
        
    }
}
