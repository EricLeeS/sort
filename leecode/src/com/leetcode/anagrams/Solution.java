package com.leetcode.anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
    	ArrayList<String> re = new ArrayList<String>();
    	if(strs.length==0){
    		return re;
    	}else{
    		Map<String,String> map = new HashMap<String,String>();
    		for(String temp : strs){
    			char[] ch = temp.toCharArray();
    			Arrays.sort(ch);
    			String ntemp=String.valueOf(ch);;
    			if(!map.isEmpty()){
    				if(map.containsKey(ntemp)){
    					if(!map.get(ntemp).equalsIgnoreCase("null")){
    						re.add(map.get(ntemp));
        					map.put(ntemp, "null");
    					}
    					
    					re.add(temp);
    				}else{
    					map.put(ntemp, temp);
    				}
    			}else{
    				map.put(ntemp, temp);
    			}
    		}
    		return re;
    	}	
    }

	
}