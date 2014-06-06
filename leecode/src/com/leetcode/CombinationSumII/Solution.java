package com.leetcode.CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
    	if(num.length==0)
    		return re;
    	ArrayList<Integer> al = new ArrayList<Integer>();
    	Arrays.sort(num);
    	FindPath(num,al,target,0,num.length-1);
    	re.addAll(remap.keySet());
		return re;
        
    }
    public  Map<ArrayList<Integer>,Integer> remap = new HashMap<ArrayList<Integer>,Integer>();
    public ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
   private void FindPath(int[] num, ArrayList<Integer> al, int target, int start, int end) {
		
		if(start>end)
			return;
		for(int i=start;i<=end;i++){
			al.add(num[i]);
			int temp = sum(al);
			if(temp==target){
				ArrayList<Integer> at = new ArrayList<Integer>();
				for(int j=0;j<al.size();j++){
					at.add(al.get(j));
				}
				remap.put(at, 1);
				al.remove(al.size()-1);
				return;
			}
			if(temp<target){
				FindPath(num,al,target,i+1,end);
				al.remove(al.size()-1);
				
			}else{
				al.remove(al.size()-1);
				return;
			}
			
		}
	}
   private int sum(ArrayList<Integer> al) {
		int re=0;
		for(int i=0;i<al.size();i++){
			re+=al.get(i);
		}
		return re;
	}
}