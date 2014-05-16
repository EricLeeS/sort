package com.leetcode.JumpGame;

import java.util.Arrays;

public class Solution {
    public boolean canJump(int[] A) {
    	if(A.length==0)
    		return true;
    	Boolean[] bol = new Boolean[A.length];
    	Arrays.fill(bol, false);
    	bol[0]=true;
    	for(int i=1;i<A.length;i++){
    		for(int j=0;j<i;j++){
    			if(bol[j]&&(A[j]+j)>=i){
    				bol[i]=true;
    				break;
    			}
    				
    		}
    	}
		return bol[A.length-1];
        
    }
}
