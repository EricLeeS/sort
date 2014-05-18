package com.leetcode.LongestConsecutiveSequence;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class NSolution {
    public int longestConsecutive(int[] num) {
    	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    	for(int j=0;j<num.length;j++){
    		map.put(num[j], Integer.MAX_VALUE);
    	}
    	for(int i=0;i<num.length;i++){
    		int temp = num[i];
    		if(map.containsKey(temp-1)){
    			map.put(temp, temp-1);
    		}
    	}
    	Queue<Integer> queue = new LinkedList<Integer>();
    	Queue<Integer> tempqueue = new LinkedList<Integer>();
    	queue.offer(Integer.MAX_VALUE);
    	int count=-1;
    	while(!queue.isEmpty()){
    		int temp = queue.peek();
    		queue.poll();
    		Set<Integer> set = map.keySet();
    		Iterator<Integer> it = set.iterator();
    		while(it.hasNext()){
    			int tt = it.next();
    			if(map.get(tt)==temp){
    				tempqueue.add(tt);
    			}
    		}
    		if(queue.isEmpty()){
    			count++;
    			queue=tempqueue;
    			tempqueue=new LinkedList<Integer>();
    		}
    	}
		return count;
        
    }
}