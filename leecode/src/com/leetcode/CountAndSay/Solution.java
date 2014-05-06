package com.leetcode.CountAndSay;

public class Solution {
    public String countAndSay(int n) {
    	
		if(n==1){
			return "1";
		}
    	String sr = "1";
    	for(int i=1;i<n;i++){
    		char[] ch= sr.toCharArray();
    		char cha=ch[0];
    		int count=1;
    		StringBuilder sb = new StringBuilder();
    		for(int j=1;j<ch.length;j++){
    			if(ch[j]==cha){
    				count++;
    			}else{
    				sb.append(String.valueOf(count));
    				sb.append(cha);
    				cha = ch[j];
    				count=1;
    			}
    			
    		}
    		sb.append(String.valueOf(count));
			sb.append(cha);
    		sr = sb.toString();
    	}
    	
    	return sr;
        
    }
}
