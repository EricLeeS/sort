package com.leetcode.ClimbingStairs;

public class Solution {
    public int climbStairs(int n) {
    	if(n==0)
    		return 0;
    	if(n==1)
    		return 1;
    	if(n==2)
    		return 2;
    	
		return FClimbStairs(n);
        
    }

    private int No(int n){
    	if(n==0)
    		return 0;
    	if(n==1)
    		return 1;
    	if(n==2)
    		return 2;
    	int[] re = new int[n];
    	re[0]=0;
    	re[1]=1;
    	re[2]=2;
    	for(int i=3;i<n+1;i++){
    		re[i]=re[i-1]+re[i-2];
    	}
		return re[n];
    	
    }
    
	private int FClimbStairs(int n) {
		// TODO Auto-generated method stub
		if(n==1)
			return 1;
		if(n==2)
			return 2;
		
		return FClimbStairs(n-1)+FClimbStairs(n-2);
	}
}
