package com.leetcode.LengthOfLastWord;

public class Solution {
    public int lengthOfLastWord(String s) {
    	int count = 0;
    	if(s.length()==0)
    		return 0;
    	
    	while(s.endsWith(" ")){
    		s=s.substring(0, s.length()-1);
    	}
    	if(s.length()==0)
    		return 0;
    	int length=s.length()-1;
    	while(s.charAt(length)!=' '){
    		count++;
    		length--;
    		if(length<0)
    			break;
    	}
		return count;
        
    }
}
