package com.leetcode.SearchInsertPosition;

public class Solution {
    public int searchInsert(int[] A, int target) {
    	if(target<A[0]){
    		return 0;
    	}
    	if(target>A[A.length-1]){
    		return A.length;
    	}
    	int re=0;;
		for(int i=0;i<A.length;i++){
			if(A[i]==target){
				re=i;
				break;
			}
			if(A[i]>target){
				re = i;
				break;
			}
		}
    	return re;
        
    }
}
