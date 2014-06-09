package com.leetcode.PermutationsII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Solution {
	public List<List<Integer>> permuteUnique(int[] num) {
    	List<List<Integer>> re = new ArrayList<List<Integer>>();
    	List<Integer> li = new ArrayList<Integer>();
    	if(num.length==0)
    		return re;
    	if(num.length==1){
    		li.add(num[0]);
    		re.add(li);
    		return re;
    	}    	
    	
    	Set<List<Integer>> set = new HashSet<List<Integer>>();
    	Set<List<Integer>> tempset = new HashSet<List<Integer>>();
    	for(int i=0;i<num.length;i++){
    		if(set.isEmpty()){
    			li=new ArrayList<Integer>();
				li.add(num[i]);
				set.add(li);  
    		}else{
    			Iterator<List<Integer>> it = set.iterator();
        		while(it.hasNext()){
        			List<Integer> ltemp = it.next();
        			for(int j=0;j<ltemp.size();j++){
        				ltemp.add(j, num[i]);
        				li=new ArrayList<Integer>();
        				li.addAll(ltemp);
        				tempset.add(li);  
        				ltemp.remove(j);
        			}
        			ltemp.add(num[i]);
        			tempset.add(ltemp);
        					
        		}
        		set= new HashSet<List<Integer>>();
        		set.addAll(tempset);
        		tempset= new HashSet<List<Integer>>();
    		}
    		
    	}
    	re.addAll(set);
		return re;
        
    }
}
