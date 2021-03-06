package com.leetcode.PalindromePartitioningII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	 public int minCut(String s) {
	    	if(s==null||s.equals(""))
	    		return 0;
	    	if(isPalindrome(s, 0, s.length()-1))
	    		return 0;
	    	Map<Character,List<Integer>> map = new HashMap<Character,List<Integer>>();
	    	int[] dp = new int[s.length()];
	    	dp[0]=0;
	    	boolean[][] bol = new boolean[s.length()][s.length()];
	    	bol[0][0]=true;
	    	List<Integer> li = new ArrayList<Integer>();
	    	li.add(0);
	    	map.put(s.charAt(0), li);
	    	for(int i=1;i<s.length();i++){
	    		char tc = s.charAt(i);
	    		bol[i][i]=true;
	    		if(!map.containsKey(tc)){
	    			li = new ArrayList<Integer>();
	    			li.add(i);
	    			map.put(tc, li);
	    			dp[i]=dp[i-1]+1;
	    		}else{
	    			List<Integer> list = map.get(tc);
	    			int min=Integer.MAX_VALUE;
	    			for(int j=0;j<list.size();j++){
	    				int temp = list.get(j);	    				
	    				if(i-temp==1){
	    					bol[temp][i]=true;
	    					if(temp==0)
	    						min=0;
	    					else{
	    						if(dp[temp-1]+1<min)
	    							min=dp[temp-1]+1;
	    						
	    					}
	    						
	    				}else if(temp==0&&isPalindrome(s, temp, i)){
	    					min=0;
	    					bol[temp][i]=true;
	    					break;
	    				}
	    				else{
	    					 if(bol[temp+1][i-1]){
	    						 bol[temp][i]=true;
	    						 if(temp!=0&&dp[i-1]>dp[temp-1]&&dp[temp-1]+1<min){	    							
	 	 	    					min=dp[temp-1]+1;
	    						 }
	 	    					
	 	    				}
	    				}
	    				
	    			}
	    			dp[i]=Math.min(min, dp[i-1]+1);
	    			map.get(tc).add(i);
	    			
	    		}
	    	}
	    	
			return dp[s.length()-1];
	    	
			
	    }
	    public int count=0;
	    private boolean isPalindrome(String s, int start, int end) {
			// TODO Auto-generated method stub
	    	System.out.println(count++);
			int i=start;
			int j=end;
			while(j>=i){
				if(s.charAt(i)!=s.charAt(j)){
					return false;
				}else{
					i++;
					j--;
				}
			}
			return true;
		}
}
