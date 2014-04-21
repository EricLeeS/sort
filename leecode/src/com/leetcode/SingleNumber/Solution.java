package com.leetcode.SingleNumber;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int singleNumber(int[] A) {
		if(A.length==0){
			return 0;
		}else if(A.length==1){
			return A[0];
		}else{
			int pre = 0;
			int re = 0;
			Map<Integer,Integer> map = new HashMap<Integer,Integer>();
			map.put(A[0], 1);
			for(int i=1;i<A.length;i++){
				if(map.containsKey(A[i])){
					map.remove(A[i]);
				}else{
					map.put(A[i], 1);
				}
			}
			Set<Integer> set = map.keySet();
			Iterator<Integer> it = set.iterator();
			return it.next();
		}
    	
        
    }
}