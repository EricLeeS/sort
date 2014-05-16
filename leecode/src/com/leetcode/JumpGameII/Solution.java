package com.leetcode.JumpGameII;

import java.util.Arrays;

public class Solution {
    public int jump(int[] A) {
    	if(A.length==0)
    		return 0;
    	if(A.length==1){
    		return 0;
    	}
    		
    	int[] step = new int[A.length];
    	step[0]=0;
    	int cur =0;
    	Arrays.fill(step, 0);
    	for(int i=0;i<A.length;i++){   		
    		int temp = i+A[i];
    		if(temp>=A.length-1){
    			return step[i]+1;
    		}
    		for(int j=cur+1;j<=temp;j++){
    			step[j]=step[i]+1;
    		}
    		if(temp>=cur)
    			cur=temp;
    	}
		return step[A.length-1];
    }
}

