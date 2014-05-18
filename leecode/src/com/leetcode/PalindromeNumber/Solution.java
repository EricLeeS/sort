package com.leetcode.PalindromeNumber;

public class Solution {
    public boolean isPalindrome(int x) {
    	if(x<0)
    		return false;
    	if(x<10)
    		return true;
    	
    	int max = 1;
    	int t =x;
    	while(!(t/max<10))
    		max*=10;
    	
    	int min=10;
    	int right = 0;
    	while(min<=max){
    		if((x-right)/max!=x%10)
    			return false;    		
    		right+=(max*((x-right)/max));
    		max=max/100;
    		x=x/10;
    		right/=10;
    		
    	}
		return true;
        
    }
}