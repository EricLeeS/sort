package com.leetcode.WordLadder;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
    	if(dict.isEmpty())
    		return 0;
    	if(start.equals(end))
    		return 0;
    	Queue<String> queue = new LinkedList<String>();
    	Queue<String> tempqueue = new LinkedList<String>();
    	HashSet<String> tempdict = new HashSet<String>();
    	queue.add(start);
    	int re =1;
    	while(dict!=null&&!queue.isEmpty()){
    		
    			String sr = queue.peek();
    			int recount = 0;
    			int j=0;
    			while(j<sr.length()){
    				if(sr.charAt(j)!=end.charAt(j))
    					recount++;
    				j++;
    			}
    			if(recount==1)
    				return re+1;
    			queue.poll();
    			Iterator<String> it = dict.iterator();
        		while(it.hasNext()){
        			String temp = it.next();
        			
        			int count = 0;
        			int i=0;
        			
        			while(i<sr.length()){
        				if(temp.charAt(i)!=sr.charAt(i)){
        					count++;
        				}
        				
        				i++;
        			}
        			
        			if(count==1){
        				tempqueue.offer(temp);
        				
        			}else{
        				tempdict.add(temp);
        			}
        				
        		}
        		if(queue.isEmpty()){
        			queue=tempqueue;
        			tempqueue= new LinkedList<String>();
        			dict=tempdict;
        			tempdict=new HashSet<String>();
        			re++;
        		}
	
    	}
		return 0;
        
    }
}
