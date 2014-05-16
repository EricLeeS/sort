package com.leetcode.WordLadderII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class NSolution {
	
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
    	Map<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
    	ArrayList<ArrayList<String>> relist = new ArrayList<ArrayList<String>>();
    	if(dict.isEmpty())
    		return relist;
    	if(start.equals(end))
    		return relist;
    	Iterator<String> it = dict.iterator();
    	HashSet<String> tempdict = new HashSet<String>();
    	
    	while(it.hasNext()){
    		String str = it.next();
    		
    		tempdict.add(str);
    		map.put(str, new ArrayList<String>());	
    	}   	
    	Queue<String> queue = new LinkedList<String>();
    	Queue<String> tempqueue = new LinkedList<String>();  
    	
    	queue.add(start);   	
    	map.put(start,new ArrayList<String>());
    	boolean flag = true;
    	
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
    				if(ns.equals(end)){
    					flag=false;
    					
    					ArrayList<String> artemp = new ArrayList<String>();
    					artemp= map.get(ns);
    					if(ns.isEmpty()){
    						artemp.add(str);
    					}else{
    						Iterator<String> ita = artemp.iterator();
    						boolean bol = false;
    						while(ita.hasNext()){
    							if(ita.next().equals(str)){
    								bol = true;;
    							}
    						}
    						if(!bol){
    							artemp.add(str);
    						}
    					}
    						
    					
    					
    				}
    					
    				if(dict.contains(ns)){
    					tempdict.remove(ns);
    					if(!tempqueue.contains(ns)){
    						tempqueue.offer(ns);
    					}
    					ArrayList<String> artemp = new ArrayList<String>();
    					artemp= map.get(ns);
    					if(ns.isEmpty()){
    						artemp.add(str);
    					}else{
    						Iterator<String> ita = artemp.iterator();
    						boolean bol = false;
    						while(ita.hasNext()){
    							if(ita.next().equals(str)){
    								bol = true;;
    							}
    						}
    						if(!bol){
    							artemp.add(str);
    						}
    					}
    					
    					
    					
    				}
    			}
    			sr[i]=temp;
    		}
    			
        		if(queue.isEmpty()&&flag){
        			queue=tempqueue;
        			tempqueue= new LinkedList<String>();
        			dict =new HashSet<String>();
        			Iterator<String> iitt = tempdict.iterator();
        			while(iitt.hasNext()){
        				dict.add(iitt.next());
        			}
        			
        			
        			
        		}
	
    	}
    	ArrayList<String> tmparray = new ArrayList<String>();
    	tmparray.add(end);
    	buildpath(start, end, map, tmparray, relist);
    	
		return relist;
        
    }

  	public void buildpath(String start, String end,
  			Map<String, ArrayList<String>> map, ArrayList<String> tmparray,
  			ArrayList<ArrayList<String>> res) {
  		ArrayList<String> pre = map.get(end);
   		if (end.equals(start)) {
   			ArrayList<String> tmparray2 = new ArrayList<String>(tmparray);
   			Collections.reverse(tmparray2);
   			res.add(tmparray2);
   			return;
   		}
   		for (String s: pre) {
   			tmparray.add(s);
   			buildpath(start, s, map, tmparray, res);
   			tmparray.remove(tmparray.size() - 1);
   		}
  			
  	}
}

