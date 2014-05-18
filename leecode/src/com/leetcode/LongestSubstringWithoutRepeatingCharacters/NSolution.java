package com.leetcode.LongestSubstringWithoutRepeatingCharacters;

import java.util.Arrays;

public class NSolution {
    public int lengthOfLongestSubstring(String s) {
    	if(s.equalsIgnoreCase("")||s.isEmpty()||null==s)
    		return 0;
    	int[] init = new int[128];
    	Arrays.fill(init, -1);
    	char[] ch = s.toCharArray();
    	int re = 0;
    	int max = 0;
    	for(int i=0;i<ch.length;i++){
    		char c = ch[i];
    		if(init[c]!=-1){
    			re=0;
    			i = init[c];
    			init = new int[128];
    			Arrays.fill(init, -1);
    		}else{
    			init[c]=i;
    			re++;
    			if(re>max)
    				max = re;
    		}
    	}
		return max;
    }
 }
 