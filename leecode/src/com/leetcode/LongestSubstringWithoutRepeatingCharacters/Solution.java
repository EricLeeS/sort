package com.leetcode.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
    	Map<Character,Integer> map = new HashMap<Character,Integer>();
    	char[] ch = s.toCharArray();
    	if(s.equalsIgnoreCase("")||s.isEmpty()||null==s)
    		return 0;
    	int re=0;
    	int max=0;
    	for(int i=0;i<ch.length;i++){
    		char c = ch[i];
    		if(map.containsKey(c)){
    			re=0;
    			i=map.get(c);
    			map = new  HashMap<Character,Integer>();
    			
    		}else{
    			map.put(c, i);
    			re++;
    			if(re>max)
    				max=re;
    		}
    	}
		return max;
        
    }
}
