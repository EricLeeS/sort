package com.leetcode.MinimumWindowSubstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String S, String T) {
    	if(T.length()==0)
    		return "";
    	if(S.length()==0)
    		return "";
    	if(T.length()>S.length())
    		return "";
    	if(T.length()==1){
    		if(S.indexOf(T.charAt(0))!=-1)
    			return T;
    		else
    			return "";
    	}
    		
    	 Map<Character, Integer> needToFill = new HashMap<Character, Integer>();
         Map<Character, Integer> hasFound = new HashMap<Character, Integer>();
         int count = 0;
         for(int i = 0; i < T.length(); i++){
             if(!needToFill.containsKey(T.charAt(i))){
                 needToFill.put(T.charAt(i), 1);
                 hasFound.put(T.charAt(i), 0);
             }else {
                 needToFill.put(T.charAt(i), needToFill.get(T.charAt(i)) + 1);
             }
         }
    	
         
    	
		return T;
        
    }
}
