package com.leetcode.PermutationsII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NSolution {
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
    	
    	
    	li=new ArrayList<Integer>();
    	
    	generate(num,li,0);
    	re.addAll(set);
		return re;
        
    }
    public Set<List<Integer>> set = new HashSet<List<Integer>>();
	private void generate(int[] num, List<Integer> li, int len) {
		if(len==num.length){
			List<Integer> ll = new ArrayList<Integer>();
			ll.addAll(li);
			set.add(ll);
			return;
		}
			
		int rr = len+1;
		for(int i=0;i<li.size();i++){
			li.add(i, num[len]);
			generate(num,li,rr);
			li.remove(i);
		}
		li.add(num[len]);
		generate(num,li,rr);
		li.remove(li.size()-1);	
		return;
	}
}
