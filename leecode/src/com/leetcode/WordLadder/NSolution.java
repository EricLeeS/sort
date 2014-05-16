package com.leetcode.WordLadder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class NSolution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
    	if(dict.isEmpty())
    		return 0;
    	if(start.equals(end))
    		return 0;
    	boolean bo = dict.contains("hot");
    	Queue<String> queue = new LinkedList<String>();
    	Queue<String> tempqueue = new LinkedList<String>();

    	queue.add(start);
    	int re =1;
    	while(dict!=null&&!queue.isEmpty()){
    		String str = queue.peek();
    		char[] sr = str.toCharArray();
    		queue.poll();
    		int len = str.length();
    		for(int i=0;i<len;i++){
    			char temp = sr[i];
    			for(char c ='a';c<='z';c++){
    				if(c==temp)
    					continue;
    				sr[i]=c;
    				String ns = String.valueOf(sr);
    				if(ns.equals(end))
    					return re+1;
    				if(dict.contains(ns)){
    					tempqueue.offer(ns);
    					dict.remove(ns);
    				}
    			}
    			sr[i]=temp;
    		}
    			
        		if(queue.isEmpty()){
        			queue=tempqueue;
        			tempqueue= new LinkedList<String>();
        			
        			re++;
        		}
	
    	}
    	
		return 0;
        
    }
    
  
}
