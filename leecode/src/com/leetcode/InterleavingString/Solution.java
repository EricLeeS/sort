package com.leetcode.InterleavingString;

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
    	int l1 = s1.length();
    	int l2 = s2.length();
    	int l3 = s3.length();
    	if((l1+l2)!=l3)
    		return false;
    	if(l1==0){
    		if(s2.equalsIgnoreCase(s3))
    			return true;
    		else
    			return false;
    	}
    	if(l2==0){
    		if(s1.equalsIgnoreCase(s3))
    			return true;
    		else
    			return false;
    	}
    	int[][] dp = new int[s2.length()+1][s1.length()+1];
    	dp[0][0]=0;
    	for(int i=0;i<s1.length();i++){
    		if(s1.charAt(i)==s3.charAt(i)){
    			dp[0][i+1]=1;
    		}else{
    			dp[0][i+1]=0;
    		}
    	}
    	for(int j=0;j<s2.length();j++){
    		if(s2.charAt(j)==s3.charAt(j)){
    			dp[j+1][0]=1;
    		}else{
    			dp[j+1][0]=0;
    		}
    	}
    	for(int x=1;x<dp.length;x++){
    		for(int y=1;y<dp[x].length;y++){
    			if(dp[x-1][y]==0&&dp[x][y-1]==0){
    				dp[x][y]=0;
    			}else if(dp[x-1][y]==1&&dp[x][y-1]==1){
    				if(s1.charAt(y-1)==s3.charAt(x+y-1)||s2.charAt(x-1)==s3.charAt(x+y-1))
    					dp[x][y]=1;
    				else
    					dp[x][y]=0;
    			}else if(dp[x-1][y]==0){
    				if(s1.charAt(y-1)==s3.charAt(x+y-1))
    					dp[x][y]=1;
    				else
    					dp[x][y]=0;
    			}else if(dp[x][y-1]==0){
    				if(s2.charAt(x-1)==s3.charAt(x+y-1))
    					dp[x][y]=1;
    				else
    					dp[x][y]=0;
    			}
    		}
    	}
		if(dp[s2.length()][s1.length()]==1)
			return true;
		else 
			return false;
    	
    }	
	
}
