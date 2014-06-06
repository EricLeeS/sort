package com.leetcode.ValidPalindrome;

public class Solution {
    public boolean isPalindrome(String s) {
    	if(s.equalsIgnoreCase("")||s==null)
    		return true;
    	int i=0;
    	int j=s.length()-1;
    	s=s.toLowerCase();
    	while(j>=i){
    		char left = s.charAt(i);
    		char right = s.charAt(j);
    		
    		if(!((left<='9'&&left>='0')||(left<='z'&&left>='a'))){
    			i++;
    			continue;
    		}
    		if(!((right<='9'&&right>='0')||(right<='z'&&right>='a'))){
    			j--;
    			continue;
    		}
    		
    		if(left<='9'&&right<='9'&&left>='0'&&right>='0'){
    			if(left==right){
    				i++;
        			j--;
        			continue;
    			}else{
    				return false;
    			}
    			
    		}
    		if(left<='z'&&left>='a'&&right>='a'&&right<='z'){
    			if(left==right){
    				i++;
    				j--;
    				continue;
    			}else{
    				return false;
    			}
    		}
    		return false;
    	}
		return true;
        
    }
}
