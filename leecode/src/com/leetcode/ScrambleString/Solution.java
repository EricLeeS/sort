package com.leetcode.ScrambleString;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean isScramble(String s1, String s2) {
    	if(s1.equals(s2))
    		return true;
		return isValid(s1,0,s1.length()-1,s2);
        
    }

	private Boolean isValid(String s1,int start,int end, String s2) {
		// TODO Auto-generated method stub
		if(start>end)
			return false;
		if(start==end&&!s1.equals(s2))
			return false;
			
		String starts = s1.substring(0, start);
		String ends = s1.substring(end+1);
		for(int i=start+1;i<=end;i++){
			String left = s1.substring(start, i);
			String right = s1.substring(i, end+1);
			String te = starts+right+left+ends;
			if(isValid(te, start, i-1, s2)||isValid(te,i,end,s2))
				return true;
		}
		return false;
	}

	
}

