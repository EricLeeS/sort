package com.leetcode.WordLadderII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
    	ArrayList<ArrayList<String>> ree = new ArrayList<ArrayList<String>>();
    	if(dict.isEmpty())
    		return re;
    	if(start.equals(end))
    		return re;
    	
    	ArrayList<String> init = new ArrayList<String>();
    	init.add(start);
    	int depth=0;
    	DFS(start,end,dict,init,depth);
    	Iterator<ArrayList<String>> it = re.iterator();
    	while(it.hasNext()){
    		ArrayList<String> temps = it.next();
    		if(temps.size()==mindepth+1)
    			ree.add(temps);
    	}
    	return re;
        
    }
    public int mindepth=-1;
    public  ArrayList<ArrayList<String>> re = new ArrayList<ArrayList<String>>();
    private void DFS(String start, String end, HashSet<String> dict,ArrayList<String> init,int depth) {
    	depth++;
    	if(mindepth!=-1&&depth>mindepth)
    		return;
    	if(dict.isEmpty())
    		return;
		int len = start.length();
		char[] sr = start.toCharArray();
		for(int i=0;i<len;i++){
			char temp = sr[i];
			for(char c='a';c<='z';c++){
				if(temp==c)
					continue;
				sr[i]=c;
				String ns = String.valueOf(sr);
				if(ns.equals(end)){
					if(mindepth==-1){
						mindepth=depth;
					}else{
						if(depth<mindepth){
							mindepth=depth;
						}
					}
						
					init.add(end);
					ArrayList<String> al = new ArrayList<String>();
					int m=0;
					while(m<init.size()){
						al.add(m, init.get(m));
						m++;
					}
					re.add(al);
					init.remove(init.size()-1);
					
				}
				if(dict.contains(ns)){
					init.add(ns);
					dict.remove(ns);
					DFS(ns,end,dict,init,depth);
					
					dict.add(ns);
					init.remove(init.size()-1);
				}

			}
			sr[i]=temp;
		}
		return;
	}
	
}