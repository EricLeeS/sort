package com.leetcode.DistinctSubsequences;

public class Solution {
    public int numDistinct(String S, String T) {
    	int slen = S.length();
    	int tlen = T.length();
    	if(slen==0||tlen==0)
    		return 0;
    	if(slen<tlen)
    		return 0;
    	int[][] dp = new int[tlen][slen];
    	if(S.charAt(0)==T.charAt(0))
    		dp[0][0]=1;
    	else
    		dp[0][0]=0;
    	for(int i=1;i<tlen;i++){
    		dp[i][0]=0;
    	}
    	for(int j=1;j<slen;j++){
    		if(S.charAt(j)==T.charAt(0)){
    			dp[0][j]=dp[0][j-1]+1;
    		}else{
    			dp[0][j]=dp[0][j-1];
    		}
    	}
    	for(int x=1;x<tlen;x++){
    		for(int y=1;y<slen;y++){
    			if(S.charAt(y)==T.charAt(x)){
    				dp[x][y]=dp[x-1][y-1]+dp[x][y-1];
    			}else{
    				dp[x][y]=dp[x][y-1];
    			}
    		}
    	}
		return dp[tlen-1][slen-1];
        
    }
}
