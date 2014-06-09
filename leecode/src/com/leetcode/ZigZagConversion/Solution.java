package com.leetcode.ZigZagConversion;

public class Solution {
    public String convert(String s, int nRows) {
    	String re = "";
    	if(s.equals("")||null==s)
    		return re;
    	if(nRows==0||nRows==1||s.length()<=nRows)
    		return s;
    	
    	int len = 2*nRows-2;
    	int j=0;
    	while(j<s.length()){
    		re+=s.charAt(j);
    		j=j+len;
    	}
    	int i=1;
    	for(i=1;i<nRows;i++){
    		if(i==nRows-1){
    			int nn=i;
    			while(nn<s.length()){
    	    		re+=s.charAt(nn);
    	    		nn=nn+len;
    	    	}
    		}else{
    			re+=s.charAt(i);
        		int temp = i;
        		boolean bol=true;
        		int init=0;
        		while(temp<s.length()){
        			if(bol){
        				init=len-2*i;
        				temp=temp+init;
        				if(temp>=s.length())
        					break;
        				bol=false;
        				re+=s.charAt(temp);
        				bol=false;
        			}else{
        				init=len-init;
        				temp=temp+init;
        				if(temp>=s.length())
        					break;
        				bol=true;
        				re+=s.charAt(temp);
        			}
        		}
    		}
    		
    	}
		return re;
        
    }
}