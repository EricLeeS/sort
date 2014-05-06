package com.leetcode.SearchforaRange;

public class Solution {
    public int[] searchRange(int[] A, int target) {
		int[] re = new int[2];
    	if(A.length==0){
    		re[0]=-1;
    		re[1]=-1;
			return re;
		}
    	int i=0;
    	int j=A.length-1;
    	
    	while(j>=i){
    		if(A[i]==target&&A[j]==target){
    			re[0]=i;
    			re[1]=j;
    			break;
    		}
    		if(A[i]!=target){
    			i++;
    		}
    		if(A[j]!=target){
    			j--;
    		}
    	}
    	if(i>j){
    		re[0]=-1;
    		re[1]=-1;
    		
    	}
		return re;
    	
        
    }
}