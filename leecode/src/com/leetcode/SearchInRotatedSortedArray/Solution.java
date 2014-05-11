package com.leetcode.SearchInRotatedSortedArray;

public class Solution {
    public int search(int[] A, int target) {
    	if(target==A[0])
    		return 0;
    	if(target>A[0]){
    		int pre = A[0];
    		for(int i=1;i<A.length;i++){
    			if(A[i]<pre)
    				return -1;
    			
    			if(A[i]==target)
    				return i;
    			
    			pre=A[i];
    		}
    	}
    	if(target<A[0]){
    		if(target==A[A.length-1])
    			return A.length-1;
    		int pre = A[A.length-1];
    		for(int i=A.length-2;i>=0;i--){
    			if(A[i]>pre)
    				return -1;
    			
    			
    			
    			if(A[i]==target){
    				return i;
    			}
    			
    			pre=A[i];
    		}
    	}
		return -1;
        
    }
}
