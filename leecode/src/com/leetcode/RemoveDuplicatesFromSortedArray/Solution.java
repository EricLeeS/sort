package com.leetcode.RemoveDuplicatesFromSortedArray;

public class Solution {
    public int removeDuplicates(int[] A) {
		if(A.length==0)
			return 0;
		int pre = A[0];
		int count = 1;

		
		for(int i=1;i<A.length;i++){
			if(A[i]==pre){
				continue;
				
			}else{
				pre = A[i];
				
				count++;
				A[count-1]=A[i];
			}
		}
    	
    	return count;
        
    }
}